package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDB 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Class.forName("com.mysql.jdbc.Driver");	
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");	
		PreparedStatement preparedStatement=connection.prepareStatement("select * from Person");
		preparedStatement.addBatch();
		preparedStatement.executeBatch();
	}
}