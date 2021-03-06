package com.bridgelabz.utility;

interface Executor 
{
	void runCommand(String command);
}

class CommandExecutor implements Executor
{
	@Override
	public void runCommand(String command) 
	{
		System.out.println("Command Executed");
	}
}

public class CommandExecutorProxy implements Executor 
{
	private boolean isAdmin;
	private Executor executor;
	
	public CommandExecutorProxy(String user, String pwd)
	{
		if("Ganesh".equals(user) && "itspassword".equals(pwd)) 
		{
			isAdmin=true;
		}
		executor = new CommandExecutor();
	}
	
	@Override
	public void runCommand(String cmd) 
	{
		if(isAdmin)
		{
			executor.runCommand(cmd);
		}
		else
		{
			if(cmd.trim().startsWith("rm"))
			{
				System.out.println("rm command is not allowed for non-admin users.");
			}
			else
			{
				executor.runCommand(cmd);
			}
		}
	}
}