package com.tweetme.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

/**
 * 
 * @author gmento
 * @description This function share the token used for the CSRF protection
 */
public class CsrfHeaderFilter extends OncePerRequestFilter {
	  @Override
	  protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response, FilterChain filterChain)
			  										throws ServletException, IOException {
		  
		System.out.println("Csrf Filter on call..");
	    CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
	    
	    CsrfToken csrfToken = (CsrfToken) request.getAttribute("_csrf");
	    //System.out.println("Csrf2:"+ csrfToken.toString());
	    
	    if (csrf != null) {
	    	//System.out.println("Csrf:"+ csrf.toString());
	    	Cookie cookie = WebUtils.getCookie(request, "XSRF-TOKEN");
	      
	      String token = csrf.getToken();
	      if (cookie==null || token!=null && !token.equals(cookie.getValue())) {
	    	  System.out.println("Preparing cookie: XSRF-TOKEN:"+ token);
	    	  cookie = new Cookie("XSRF-TOKEN", token);
	        cookie.setPath("/");
	        response.addCookie(cookie);
	      }
	    }
	    filterChain.doFilter(request, response);
	  }
	}
