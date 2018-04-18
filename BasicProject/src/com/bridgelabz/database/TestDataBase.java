package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestDataBase 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		String query=null;
		ResultSet resultSet=null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Practice", "root", "root");
//		query="create table Table1(Name varchar(20));";
//		query="insert into Table1 values('ganesh')";
//		query="insert into Table1 values(?)";
		query="select * from Table1";
		PreparedStatement ps=connection.prepareStatement(query);
		
//		ps.setString(1, "JasVim");
		System.out.println(ps.executeQuery().getString(1));
//		resultSet=ps.executeQuery();
//		List<String> list=new ArrayList<>();
//		while(resultSet.next())
//		{
//			list.add(resultSet.getString(1));
//		}
//		System.out.println(list);
	}
}