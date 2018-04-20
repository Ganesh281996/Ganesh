package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BatchPreparedStatement 
{
	public static void main(String[] args) 
	{
		Scanner scanner=new Scanner(System.in);
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String query=null;
		String name=null;
		int age=0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			connection.setAutoCommit(false);
			
			System.out.println("Insert");
			System.out.println("Enter Name");
			name=scanner.next();
			System.out.println("Enter Age");
			age=scanner.nextInt();
			query="insert into Person "
					+"(Name,Age)"
					+"values(?,?)";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, age);
			preparedStatement.addBatch();
			
			System.out.println("Update");
			System.out.println("Enter Name");
			name=scanner.next();
			System.out.println("Enter Age");
			age=scanner.nextInt();
			query="update Person "
					+"set age=? where name=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, age);
			preparedStatement.setString(2, name);
			preparedStatement.addBatch();
			
			System.out.println("Delete");
			System.out.println("Enter Name");
			name=scanner.next();
			query="delete from Person where name=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.addBatch();
			
			preparedStatement.executeBatch();
			System.out.println("Before Commit Enter number to commit");
			scanner.nextInt();
			connection.commit();
			System.out.println("Commited");
			
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