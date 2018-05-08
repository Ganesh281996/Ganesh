package com.bridgelabz.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashSet;

import com.bridgelabz.clinique.Doctor;

public class TestDB 
{
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
//		Class.forName("com.mysql.jdbc.Driver");	
//		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Kalyan", "root", "root");	
//		PreparedStatement preparedStatement=connection.prepareStatement("select * from Person");
//		preparedStatement.addBatch();
//		preparedStatement.executeBatch();
		HashSet<Doctor> h=new HashSet<>();
//		String s1="abc";
//		String s2="abcg";
//		h.add(s1);
//		h.add(s2);
//		System.out.println(h);
		Doctor d1=new Doctor(1, "a", "gsg", "sgfsd", 2);
		Doctor d2=new Doctor(1, "a", "gsg", "sgfsd", 2);
		h.add(d1);
		h.add(d2);
		System.out.println(h);
		System.out.println(d1.hashCode());
		System.out.println(d2.hashCode());
	}
}