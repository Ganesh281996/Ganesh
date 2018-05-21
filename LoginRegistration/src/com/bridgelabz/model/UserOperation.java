package com.bridgelabz.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserOperation
{
	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	String query;
	int noOfRows;
	
	public int insert(User user)
	{
		connection=DBConnectionManager.getConnection();
		query="insert into Users values(?,?,?,?,?,?,?)";
		try
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getGender());
			preparedStatement.setString(3, user.getDateOfBirth());
			preparedStatement.setString(4, user.getEmail());
			preparedStatement.setString(5, user.getPhone());
			preparedStatement.setString(6, user.getAddress());
			preparedStatement.setString(7, user.getPassword());
			noOfRows=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return noOfRows;
	}
	
	public int delete(String email,String password)
	{
		connection=DBConnectionManager.getConnection();
		query="delete from Users where Email=? and Password=?";
		try
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			noOfRows=preparedStatement.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return noOfRows;
	}
	
	public ResultSet select()
	{
		connection=DBConnectionManager.getConnection();
		query="select * from Users";
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return resultSet;
	}
	
	public boolean ifPresent(ResultSet resultSet,User user)
	{
		try 
		{
			while(resultSet.next())
			{
				if(resultSet.getString(4).equals(user.getEmail()))
				{
					return true;
				}
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	
	public ResultSet login(String email,String password)
	{
		connection=DBConnectionManager.getConnection();
		query="select * from Users where Email=? and Password=?";
		try 
		{
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, password);
			resultSet=preparedStatement.executeQuery();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return resultSet;
	}
}