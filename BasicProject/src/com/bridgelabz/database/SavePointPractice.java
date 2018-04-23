package com.bridgelabz.database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.Properties;
import java.util.Scanner;

public class SavePointPractice 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new  Scanner(System.in);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Savepoint savepoint=null;
		Properties properties=new Properties();
		String driverClass=null,url=null,userName=null,password=null;
		FileInputStream file=null;
		try 
		{
			file = new FileInputStream("/home/bridgeit/Ganesh/BasicProject/Files/SavePoint.properties");
			properties.load(file);
			driverClass = properties.getProperty("mysql.driver");
			url = properties.getProperty("mysql.url");
			userName = properties.getProperty("mysql.username");
			password = properties.getProperty("mysql.password");
		} 
		catch (FileNotFoundException e1)
		{
			e1.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		String name=null;
		String branch=null;
		String query="insert into Student"
				+"(Name,Branch)"
				+"values"
				+"(?,?)";
		try 
		{
//			Class.forName("com.mysql.jdbc.Driver");
//			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			Class.forName(driverClass);
			connection=DriverManager.getConnection(url, userName, password);
			connection.setAutoCommit(false);
			
			preparedStatement=connection.prepareStatement(query);
			for(int i=0;i<2;i++)
			{
				savepoint=connection.setSavepoint();
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Branch");
				branch=scanner.next();
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, branch);
				preparedStatement.executeUpdate();
			}
			connection.rollback(savepoint);
			connection.commit();
		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(file!=null)
			{
				try
				{
					file.close();
				}
				catch(IOException e)
				{
					e.printStackTrace();
				}
			}
			if(preparedStatement!=null)
			{
				try 
				{
					preparedStatement.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(connection!=null)
			{
				try 
				{
					connection.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		scanner.close();
	}
}