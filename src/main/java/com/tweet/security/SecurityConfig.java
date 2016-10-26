package com.tweet.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.tweetme.filters.CsrfHeaderFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		http
//			.authorizeRequests()
//				.antMatchers("/css/**", "/index").permitAll()		
//				.antMatchers("/api/**").hasRole("USER")			
//				.and()
//			.formLogin();
		//A custom login form
	//			.loginPage("/web/login").failureUrl("/login")
		http.httpBasic();
		
		http.authorizeRequests()
          	.antMatchers("/index.html", "/red_login.html", "/home.html", "/login/**", "/js/**","/styles/**","/user").permitAll()
          	.anyRequest().authenticated();

		http.csrf()
			.csrfTokenRepository(csrfTokenRepository()).and()
			.addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
		
		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/index.html").deleteCookies("JSESSIONID")
		.invalidateHttpSession(true);
		
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		final String auth_method = "IN_MEM";
		
		if (auth_method.equals("JDBC")) {
		 auth.jdbcAuthentication().dataSource(dataSource)
			.usersByUsernameQuery(
				"select username,password, enabled from users where username=?")
			.authoritiesByUsernameQuery(
				"select username, role from user_roles where username=?");
		}
		else if (auth_method.equals("IN_MEM")) {
		 auth
			.inMemoryAuthentication()
				.withUser("user").password("password").roles("USER");
		}
	}
	
	
	private CsrfTokenRepository csrfTokenRepository() {
		  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
		  repository.setHeaderName("X-XSRF-TOKEN");
		  return repository;
		}
}
