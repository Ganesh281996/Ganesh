package com.bridgelabz.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController extends HttpServlet 
{
	private static final long serialVersionUID = 7180380630726729L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		out.println(session.getAttribute("Email")+" has been logged out");
		session.removeAttribute("Email");
		session.removeAttribute("Password");
		session.invalidate();
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("Home.jsp");
		requestDispatcher.include(request, response);
	}
}