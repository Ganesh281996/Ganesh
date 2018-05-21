package com.bridgelabz.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.User;
import com.bridgelabz.model.UserOperation;

public class SignUpController extends HttpServlet 
{
	private static final long serialVersionUID = 9034641298723574744L;
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserOperation userOperation=new UserOperation(); 
		ResultSet resultSet=null;
		PrintWriter out=response.getWriter();
		RequestDispatcher requestDispatcher=null;
		
		String name=request.getParameter("UserName");
		String gender=request.getParameter("Gender");
		String dateOfBirth=request.getParameter("DateOfBirth");
		String email=request.getParameter("Email");
		String phone=request.getParameter("Phone");
		String address=request.getParameter("Address");
		String password=request.getParameter("Password");
		User user=new User(name, gender, dateOfBirth, email, phone, address, password);
		
		resultSet=userOperation.select();
		if(!userOperation.ifPresent(resultSet,user))
		{
			userOperation.insert(user);
			out.println("Successfully Signed Up");
			requestDispatcher=request.getRequestDispatcher("Home.jsp");
			requestDispatcher.include(request, response);		
		}
		else
		{
			out.println("Email already Present");
			requestDispatcher=request.getRequestDispatcher("Signup.jsp");
			requestDispatcher.include(request, response);
		}
	}
}