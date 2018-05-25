package com.bridgelabz.controllers;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.UserOperation;

public class DisplayController extends HttpServlet 
{
	private static final long serialVersionUID = 9200391354193205440L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		UserOperation userOperation=new UserOperation();
		ResultSet resultSet=userOperation.select();
		request.setAttribute("Users", resultSet);
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("display");
		requestDispatcher.forward(request, response);
	}
}