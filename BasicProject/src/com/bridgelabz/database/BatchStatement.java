package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Scanner;

public class BatchStatement 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		Connection connection=null;
		Statement statement=null;
		Savepoint savepoint=null;
		String query=null;
		String name=null;
		int age=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			connection.setAutoCommit(false);
			statement=connection.createStatement();

			System.out.println("Insert");
			System.out.println("Enter Name");
			name=scanner.next();
			System.out.println("Enter Age");
			age=scanner.nextInt();
			query="insert into Person "
					+"(Name,Age)"
					+"values('"+name+"',"+age+")";
			statement.addBatch(query);
			
			savepoint=connection.setSavepoint();
			
			System.out.println("Update");
			System.out.println("Enter Name");
			name=scanner.next();
			System.out.println("Enter Age");
			age=scanner.nextInt();
			query="update Person "
					+"set age="+age+" where name='"+name+"'";
			statement.addBatch(query);
			
			System.out.println("Delete");
			System.out.println("Enter Name");
			name=scanner.next();
			query="delete from Person where name='"+name+"'";
			statement.addBatch(query);
			
			statement.executeBatch();
			connection.rollback(savepoint);
			System.out.println("1. Commit");
			System.out.println("2. Rollback");
			System.out.println("Enter your Choice");
			int choice=scanner.nextInt();
			if(choice==1)
			{
				connection.commit();
			}
			else
			{
				connection.rollback();
			}
			
			scanner.close();
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
			if(statement!=null)
			{
				try
				{
					statement.close();
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