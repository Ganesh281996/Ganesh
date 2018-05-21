package com.bridgelabz.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener 
{
	static int noOfSessions=0;
	
    public void sessionCreated(HttpSessionEvent arg0)  
    { 
    	System.out.println("Session has been created");
    	noOfSessions++;
    	System.out.println("No Of Sessions="+noOfSessions);
    }
    public void sessionDestroyed(HttpSessionEvent arg0)  
    { 
    	System.out.println("Session has been Destroyed");
    }
}