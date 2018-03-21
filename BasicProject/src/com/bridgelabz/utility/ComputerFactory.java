package com.bridgelabz.utility;

public class ComputerFactory
{
	public Computer getInstance(String string)
	{
		if(string.equalsIgnoreCase("Pc"))
		{
			
		}
		return null;
	}
}

interface Computer
{
	Computer getInstance();
}

class Pc implements Computer
{
	private static final Pc instance=new Pc();
	
	@Override
	public Computer getInstance() 
	{
		return instance;
	}
}

class Server implements Computer
{
	private static final Server instance=new Server();
	
	@Override
	public Computer getInstance() 
	{
		return instance;
	}
}

class Laptop implements Computer
{
	private static final Laptop instance=new Laptop();
	
	@Override
	public Computer getInstance()
	{
		return instance;
	}
	
}