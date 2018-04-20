package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class LoginDataBase 
{
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) 
	{ 
		int choice=0;
		String query=null;
		String name=null;
		String password=null;
		do
		{
			System.out.println("1. Create Table");
			System.out.println("2. Sign Up");
			System.out.println("3. Sign In");
			System.out.println("4. View Logins");
			System.out.println("5. Exit");
			System.out.println("Enter your Choice");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				query="create table Logins"
						+"(Id int auto_increment primary key,"
						+"Name varchar(20) unique key,"
						+"Password varchar(20))";
				createTable(query);
				break;
			case 2:
				query="insert into Logins"
						+"(Name,Password)"
						+"values(?,?)";
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Password");
				password=scanner.next();
				signUp(query, name, password);
				break;
			case 3:
				query="select * from Logins "
						+"where Name=? and Password=?";
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Password");
				password=scanner.next();
				signIn(query, name, password);
				break;
			case 4:
				query="select * from Logins";
				displayLogins(query);
				break;
			}
		}
		while(choice!=5);
		scanner.close();
	}
	static void createTable(String query)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.executeUpdate();
			System.out.println("Table Created");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement!=null)
			{
				try
				{
					preparedStatement.close();
				}
				catch(SQLException e)
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
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	static void signUp(String query,String name,String password)
	{
		int result=0;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			result=preparedStatement.executeUpdate();
			if(result>0)
			{
				System.out.println("Signed Up");
			}
			else
			{
				System.out.println("UserName already Present");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(preparedStatement!=null)
			{
				try
				{
					preparedStatement.close();
				}
				catch(SQLException e)
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
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	static void signIn(String query,String name,String password)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				System.out.println("Welcome "+resultSet.getString(2));
			}
			else
			{
				System.out.println("Login Failed");
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
				}
				catch(SQLException e)
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
				catch(SQLException e)
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
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	static void displayLogins(String query)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				System.out.print(" Id="+resultSet.getInt(1));
				System.out.print(" Name="+resultSet.getString(2));
				System.out.print(" Password="+resultSet.getString("Password"));
				System.out.println();
			}
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(resultSet!=null)
			{
				try
				{
					resultSet.close();
				}
				catch(SQLException e)
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
				catch(SQLException e)
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
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}	
}