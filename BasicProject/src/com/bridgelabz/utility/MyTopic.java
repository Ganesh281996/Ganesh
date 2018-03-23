package com.bridgelabz.utility;

import java.util.ArrayList;
import java.util.List;

interface Subject 
{
	public void register(Observer observer);
	public void unRegister(Observer observer);
	public void notifyObserver();
	public Object getUpdate(Observer observer);
}

interface Observer 
{
	public void update();
	public void setSubject(Subject sub);
}

public class MyTopic implements Subject 
{
	private List<Observer> observers;
	private String message;
	private boolean changed;
	
	public MyTopic()
	{
		this.observers=new ArrayList<>();
	}
	@Override
	public void register(Observer obj) 
	{
		if(obj == null)
		{
			 System.out.println("Null Observer");
		}			
		if(!observers.contains(obj))
		{
			observers.add(obj);
		}
	}

	@Override
	public void unRegister(Observer obj) 
	{
		observers.remove(obj);
	}

	@Override
	public void notifyObserver() 
	{
		List<Observer> observersLocal = null;
		if (changed)
		{
			observersLocal = new ArrayList<Observer>(this.observers);
			this.changed=false;
			for (Observer observer : observersLocal) 
			{
				observer.update();
			}
		}
	}

	@Override
	public Object getUpdate(Observer observer) 
	{
		return this.message;
	}
	
	public void postMessage(String message)
	{
		System.out.println("Message Posted to Topic:"+message);
		this.message=message;
		this.changed=true;
		notifyObserver();
	}
}