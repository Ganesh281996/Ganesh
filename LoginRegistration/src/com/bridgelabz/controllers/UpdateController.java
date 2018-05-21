package com.bridgelabz.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.model.User;
import com.bridgelabz.model.UserOperation;

public class UpdateController extends HttpServlet 
{
	private static final long serialVersionUID = 280547653009492981L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserOperation userOperation=new UserOperation(); 
		PrintWriter out=response.getWriter();
		RequestDispatcher requestDispatcher=null;
		HttpSession session=request.getSession();
		
		String name=request.getParameter("UserName");
		String gender=request.getParameter("Gender");
		String dateOfBirth=request.getParameter("DateOfBirth");
		String email=(String)session.getAttribute("Email");
		String phone=request.getParameter("Phone");
		String address=request.getParameter("Address");
		String password=request.getParameter("Password");
		User user=new User(name, gender, dateOfBirth, email, phone, address, password);
		
		userOperation.delete(email, (String)session.getAttribute("Password"));
		session.setAttribute("Password", password);
		userOperation.insert(user);
		out.println("Successfully Updated Data");
		requestDispatcher=request.getRequestDispatcher("Welcome.jsp");
		requestDispatcher.include(request, response);		
	}
}