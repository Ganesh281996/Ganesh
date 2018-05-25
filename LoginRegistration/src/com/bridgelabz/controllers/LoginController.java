package com.bridgelabz.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bridgelabz.model.UserOperation;

public class LoginController extends HttpServlet 
{
	private static final long serialVersionUID = 7095483138687406304L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		RequestDispatcher requestDispatcher=null;
		PrintWriter out=response.getWriter();
		UserOperation userOperation=new UserOperation();
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		ResultSet resultSet=userOperation.login(email, password);
		try 
		{
			if(resultSet.next())
			{
				HttpSession session=request.getSession();
				session.setAttribute("Email", resultSet.getString(4));
				session.setAttribute("Password", resultSet.getString(7));
				response.sendRedirect("welcome");
			}
			else
			{
				out.println("EmailId and Password did not match");
				requestDispatcher=request.getRequestDispatcher("login");
				requestDispatcher.include(request, response);
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}