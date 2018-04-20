package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PrepareStatementPractice 
{
	static Scanner scanner=new Scanner(System.in);

	public static void main(String[] args) 
	{
		int choice=0;
		String query=null;
		String name=null;
		String branch=null;
		
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
				query="create table Student"
						+"("
						+"Id int auto_increment primary key,"
						+"Name varchar(20),"
						+"Branch varchar(20)"
						+")";
				create(query);
				break;
			case 2:
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Branch");
				branch=scanner.next();
				query="insert into Student"
						+"(Name,Branch)"
						+"values"
						+"(?,?)";
				insert(query,name,branch);
				break;
			case 3:
				System.out.println("Enter Existing name");
				name=scanner.next();
				System.out.println("Enter New name");
				query="update Student "
				+"set name=? where name=?";
				update(query,name,scanner.next());
				break;
			case 4:
				System.out.println("Enter name to delete");
				name=scanner.next();
				query="delete from Student "
				+"where name=?";
				delete(query,name);
				break;
			case 5:
				query="select * from Student";
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
		PreparedStatement preparedStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.executeUpdate();
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
	}
	static void insert(String query,String name,String branch)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, branch);
			preparedStatement.executeUpdate();
			System.out.println("Inserted");
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
	}
	static void update(String query,String name1,String name2)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name1);
			preparedStatement.setString(2, name2);
			preparedStatement.executeUpdate();
			System.out.println("Updated");
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
	}
	static void delete(String query,String name)
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			System.out.println("Deleted");
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
	}	
	static void display(String query)
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
				System.out.print("Id="+resultSet.getInt(1)+"   ");
				System.out.print("Name="+resultSet.getString(2)+"   ");
				System.out.print("Branch="+resultSet.getString(3)+"   ");
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
			if(resultSet!=null)
			{
				try 
				{
					resultSet.close();
				} 
				catch (SQLException e)
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
	}
	static void multipleInsert()
	{
		String query=null;
		String name=null;
		int number=0;
		String branch=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			System.out.println("How many row to Insert");
			number=scanner.nextInt();
			query="insert into Student"
					+"(Name,Branch)"
					+"values"
					+"(?,?)";
			preparedStatement=connection.prepareStatement(query);
			for(int i=1;i<=number;i++)
			{
				System.out.println("Enter Name");
				name=scanner.next();
				System.out.println("Enter Branch");
				branch=scanner.next();
				preparedStatement.setString(1, name);
				preparedStatement.setString(2, branch);
				
				preparedStatement.executeUpdate();
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
	}
}