package com.bridgelabz.singleton;

public class StaticInitialization 
{
	private static StaticInitialization instance;
	
	private StaticInitialization()
	{
		
	}
	
	static
	{
		try
		{
			instance=new StaticInitialization();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public static StaticInitialization getInstance() 
	{
		return instance;
	}
	
}