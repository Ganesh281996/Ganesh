package com.hibernate;

import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.hibernate.Transaction;  
import org.hibernate.cfg.Configuration;  
  
public class StoreData 
{ 
	public static void main(String[] args)
	{  
	    Configuration cfg=new Configuration();  
	    cfg.configure("hibernate.cfg.xml");
	    SessionFactory factory=cfg.buildSessionFactory();  
	    Session session=factory.openSession();  
	    Transaction t=session.beginTransaction();  
	          
	    Employee e1=new Employee();  
	    e1.setId(117);  
	    e1.setFirstName("sonoo");  
	    e1.setLastName("jaiswal");  
	      
	    session.persist(e1);
	      
	    t.commit();
	    session.close();  
	      
	    System.out.println("successfully saved");    
	} 
}  