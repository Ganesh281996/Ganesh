package com.bridgelabz.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager 
{
	private DBConnectionManager() 
	{
		
	}
	static Connection connection;
	public static Connection getConnection()
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/LoginRegistration","root","root");
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return connection;
	}
}