package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StatementPractice 
{
	static Scanner scanner=new Scanner(System.in);
	
	public static void main(String[] args) 
	{
		int choice=0;
		String query=null;
		String name=null;
		int salary=0;
		String department=null;
		
		do
		{
			System.out.println("1. create");
			System.out.println("2. insert");
			System.out.println("3. Update");
			System.out.println("4. Delete");
			System.out.println("5. Display");
			System.out.println("6. Multiple Insert");
			System.out.println("7. Exit");
			System.out.println("Enter your Choice");
			choice=scanner.nextInt();
			switch(choice)
			{
			case 1:
				query="create table Employee"
						+"("
						+"Id int auto_increment primary key,"
						+"Name varchar(20),"
						+"Salary int,"
						+"Department varchar(20)"
						+")";
				create(query);
				break;
			case 2:
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Salary");
				salary=scanner.nextInt();
				System.out.println("Enter Department");
				department=scanner.next();
				query="insert into Employee"
						+"(Name,Salary,Department)"
						+"values"
						+"('"
						+name+"',"+"'"+salary+"',"+"'"+department+"'"
						+")";
				insert(query);
				break;
			case 3:
				query="update Employee "
				+"set name='VimJas' where name='JasVim'";
				update(query);
				break;
			case 4:
				query="delete from Employee "
				+"where name='JahibernatesVim'";
				delete(query);
				break;
			case 5:
				query="select * from Employee";
				display(query);
				break;
			case 6:
				multipleInsert();
				break;
			}
		}
		while(choice!=7);
		scanner.close();
	}
	static void create(String query)
	{
		Connection connection=null;
		Statement statement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Table Created");
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
			if(statement!=null)
			{
				try 
				{
					statement.close();
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
	}
	static void insert(String query)
	{
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Inserted");
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
	}
	static void update(String query)
	{
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Updated");
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
	}
	static void delete(String query)
	{
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			statement=connection.createStatement();
			statement.executeUpdate(query);
			System.out.println("Deleted");
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
	}	
	static void display(String query)
	{
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			statement=connection.createStatement();
			resultSet=statement.executeQuery(query);
			while(resultSet.next())
			{
				System.out.print("Id="+resultSet.getInt(1)+"   ");
				System.out.print("Name="+resultSet.getString(2)+"   ");
				System.out.print("Salary="+resultSet.getInt(3)+"   ");
				System.out.print("Department="+resultSet.getString(4)+"   ");
				System.out.println();
			}
			System.out.println("Displayed");
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
	}
	static void multipleInsert()
	{
		String query=null;
		String name=null;
		int salary=0;
		int number=0;
		String department=null;
		Connection connection=null;
		Statement statement=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			System.out.println("How many row to Insert");
			number=scanner.nextInt();
			for(int i=1;i<=number;i++)
			{
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Salary");
				salary=scanner.nextInt();
				System.out.println("Enter Department");
				department=scanner.next();
				query="insert into Employee"
						+"(Name,Salary,Department)"
						+"values"
						+"('"
						+name+"',"+"'"+salary+"',"+"'"+department+"'"
						+")";
				statement=connection.createStatement();
				statement.executeUpdate(query);
			}
			System.out.println("Inserted");
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
	}
}