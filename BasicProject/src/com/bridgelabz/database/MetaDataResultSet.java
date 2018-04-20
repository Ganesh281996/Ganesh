package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class MetaDataResultSet 
{
	public static void main(String[] args) 
	{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		ResultSetMetaData resultSetMetaData=null;
		String query=null;
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");
			query="select * from Person";
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			resultSetMetaData=resultSet.getMetaData();
			System.out.println("Number Of Columns "+resultSetMetaData.getColumnCount());
			System.out.println("Column Name "+resultSetMetaData.getColumnName(2));
			System.out.println("Column Type "+resultSetMetaData.getColumnTypeName(2));
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