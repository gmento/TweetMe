package com.tweetme.rest;

import java.io.IOException;
import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityController {

	
	  @RequestMapping("/user")
	  public Principal user(Principal user) {
	    return user;
	  }

//	  @RequestMapping(value="/logout", method = RequestMethod.GET)
//	    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
//	        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	        if (auth != null){
//	        	System.out.println("auth presente");
//	            new SecurityContextLogoutHandler().logout(request, response, auth);
//	        }
//	        try {
//				response.sendRedirect("index.html");
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        System.out.println("Log out successfully completed.");
//	        return "redirect://index.html";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
//	    }

}
