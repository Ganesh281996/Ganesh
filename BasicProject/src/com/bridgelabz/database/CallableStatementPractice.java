package com.bridgelabz.database;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class CallableStatementPractice
{
	public static void main(String[] args) 
	{
		int choice=0;
		String query=null;
		String name=null;
		int age=0;
		Scanner scanner=new Scanner(System.in);
		do
		{
			System.out.println("1. create");
			System.out.println("2. insert");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Display");
			System.out.println("6. Exit");
			System.out.println("Enter your Choice");
			choice=scanner.nextInt();
			
			switch(choice)
			{
			case 1:
				query="{call createTable()}";
				create(query);
				break;
			case 2:
				query="{call insertIntoTable(?,?)}";
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Age");
				age=scanner.nextInt();
				insert(query, name, age);
				break;
			case 3:
				query="{call updateTable()}";
				
				break;
			case 4:
				query="{call deleteFromTable(?)}";
				System.out.println("Enter Name");
				name=scanner.next();
				delete(query,name);
				break;
			case 5:
				query="{call display()}";
				
				break;
			}
		}
		while(choice!=6);
		scanner.close();
	}
	static void create(String query)
	{
		Connection connection=null;
		CallableStatement callableStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			callableStatement=connection.prepareCall(query);
			callableStatement.executeUpdate();
		} 
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(callableStatement!=null)
			{
				try
				{
					callableStatement.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	static void insert(String query,String name,int age)
	{
		Connection connection=null;
		CallableStatement callableStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			callableStatement=connection.prepareCall(query);
			callableStatement.setString(1, name);
			callableStatement.setInt(2, age);
			callableStatement.executeUpdate();
		} 
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(callableStatement!=null)
			{
				try
				{
					callableStatement.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	static void update(String query)
	{
		Connection connection=null;
		CallableStatement callableStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			callableStatement=connection.prepareCall(query);
			callableStatement.executeUpdate();
		} 
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(callableStatement!=null)
			{
				try
				{
					callableStatement.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	static void delete(String query,String name)
	{
		Connection connection=null;
		CallableStatement callableStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			callableStatement=connection.prepareCall(query);
			callableStatement.setString(1, name);
			callableStatement.executeUpdate();
		} 
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(callableStatement!=null)
			{
				try
				{
					callableStatement.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	static void display(String query)
	{
		Connection connection=null;
		CallableStatement callableStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			callableStatement=connection.prepareCall(query);
			callableStatement.executeUpdate();
		} 
		catch(ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(callableStatement!=null)
			{
				try
				{
					callableStatement.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}