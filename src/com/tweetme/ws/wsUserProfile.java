/**
 * 
 */
package com.tweetme.ws;


import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.Transaction;
import org.hibernate.Query;

import com.google.gson.*;
import com.tweetme.database.*;


/**
 * @author gmento
 *
 */
@Path("/profile")
public class wsUserProfile {
	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String getUserProfile(){
		System.out.println("starting");
		long startTime = System.currentTimeMillis();
		//Get list of Users
		//creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
//	    //creating seession factory object  
	   
	    SessionFactory factory=cfg.buildSessionFactory();  
//	      
	    //creating session object  
	    Session session=factory.openSession();  
//	      
//	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
//	    
//	    
    	//read table Employee
	    Query query = session.createQuery("FROM UserProfile");
//	    								//+ "WHERE ee.idCompany = cc.id");
	    //t.commit();
	    List<UserProfile> pairs = query.list();
////	    
////	    while ( pairs.hasNext() ) {
////	    	  
////	    	//pairs.next();
////	    	UserProfile pair = (UserProfile) pairs.next();
////	    	
////	    	System.out.println("Employee - "+ pair.getName() + " " + pair.getSurname() + " " + pair.getEmail() );
////	    }
////	    
//	    session.close();
	    Gson gson = new Gson();
		String res = gson.toJson(pairs);
		

		long endTime = System.currentTimeMillis();
		System.out.println("I am done:" + (startTime - endTime));
	    return res;
	}
	
	@PostConstruct
	public void init() {
		System.out.println("I am on init();");
	}

}
