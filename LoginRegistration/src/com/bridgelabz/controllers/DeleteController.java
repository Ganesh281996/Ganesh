package com.bridgelabz.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bridgelabz.model.UserOperation;

public class DeleteController extends HttpServlet 
{
	private static final long serialVersionUID = 666742813228909255L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("Email");
		String password=request.getParameter("Password");
		UserOperation userOperation=new UserOperation();
		userOperation.delete(email, password);
		response.sendRedirect("displaycontroller");
	}
}