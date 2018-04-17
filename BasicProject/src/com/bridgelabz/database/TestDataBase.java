package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDataBase 
{
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		String query=null;
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Practice", "root", "root");
//		query="create table Table1(Name varchar(20));";
//		query="insert into Table1 values('ganesh')";
		query="insert into Table1 values(?)";
		
		PreparedStatement ps=connection.prepareStatement(query);
		
		ps.setString(1, "JasVim");
		
		ps.executeUpdate();
	}
}