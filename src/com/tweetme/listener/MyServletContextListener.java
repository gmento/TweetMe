/**
 * 
 */
package com.tweetme.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author gmento
 *
 */


public class MyServletContextListener implements ServletContextListener{
	
	public Session session;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContextListener closing connections");
		this.session.close();
	}

        //Run this before web application is started
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		ServletContext sc = event.getServletContext();
		
		System.out.println("----------------- Tweet Me ----------------");
		System.out.println("-------         STARTING SERVER     -------");
		System.out.println("-------------------------------------------");
		
		System.out.println("Starting database pool connection");
		Configuration cfg=new Configuration();  
		cfg.configure("hibernate.cfg.xml");//populates the data of the configuration file  
		//creating session factory object  
		SessionFactory factory=cfg.buildSessionFactory();  
		//creating session object  
		this.session=factory.openSession();
		System.out.println("Store database session");	
			sc.setAttribute("session", session);
	}
}