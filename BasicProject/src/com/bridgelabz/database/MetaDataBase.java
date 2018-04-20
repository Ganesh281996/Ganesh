package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MetaDataBase 
{
	public static void main(String[] args) 
	{
		Connection connection=null;
		DatabaseMetaData databaseMetaData=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			databaseMetaData=connection.getMetaData();
			System.out.println("Driver Name: "+databaseMetaData.getDriverName());  
			System.out.println("Driver Version: "+databaseMetaData.getDriverVersion());  
			System.out.println("UserName: "+databaseMetaData.getUserName());  
			System.out.println("Database Product Name: "+databaseMetaData.getDatabaseProductName());  
			System.out.println("Database Product Version: "+databaseMetaData.getDatabaseProductVersion());  

		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
			{
				try
				{
					connection.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}