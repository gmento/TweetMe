/**
 * 
 */
package com.tweetme.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.hibernate.Query;
import org.hibernate.Session;

import com.google.gson.Gson;
import com.tweetme.database.UserProfile;

import javax.servlet.*;
/**
 * @author gmento
 *
 */
@Path("/names")
public class wsNames {
	
	 @Context ServletContext ctx;

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getName(){
		System.out.println("with pool db");
		System.out.println("starting");
		long startTime = System.currentTimeMillis();
			
		Session session = (Session) ctx.getAttribute("session");
		
		session.beginTransaction();
		Query query = session.createQuery("FROM UserProfile");
		 List<UserProfile> pairs = query.list();
		 Gson gson = new Gson();
			String res = gson.toJson(pairs);
		
			long endTime = System.currentTimeMillis();
			System.out.println("I am done:" + (startTime - endTime));
		    return res;
	}
}
