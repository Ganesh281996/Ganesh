package com.bridgelabz.utility;

public class ComputerFactory
{
	public Computer getComputer(String details)
	{
		if(details.equalsIgnoreCase("Pc"))
		{
			return new Pc(details);
		}
		else if(details.equalsIgnoreCase("Laptop"))
		{
			return new Laptop(details);
		}
		else
		{
			return new Server(details);
		}
	}
}