package com.tweetme.database;

import java.util.Iterator;

import com.tweetme.database.UserProfile;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class test {

	public static void main(String[] args) {  
	      
	    //creating configuration object  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
	      
	    //creating seession factory object  
	    SessionFactory factory=cfg.buildSessionFactory();  
	      
	    //creating session object  
	    Session session=factory.openSession();  
	      
	    //creating transaction object  
	    Transaction t=session.beginTransaction();  
	    
	    
	    	//read table Employee
	    Query query = session.createQuery("FROM UserProfile");
	    								//+ "WHERE ee.idCompany = cc.id");
	    //t.commit();
	    Iterator pairs = query.list().iterator();
	    
	    while ( pairs.hasNext() ) {
	    	  
	    	//pairs.next();
	    	UserProfile pair = (UserProfile) pairs.next();
	    	
	    	System.out.println("Employee - "+ pair.getName() + " " + pair.getSurname() + " " + pair.getEmail() );
	    }
	    
	    session.close();  
	      
	    System.out.println("successfully saved");  
	      
	}
	
}
