package com.servletdemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TimePassServlet")
public class TimePassServlet extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String nothing=request.getParameter("Nothing");
		PrintWriter printWriter=response.getWriter();
		printWriter.write(nothing);
//		RequestDispatcher requestDispatcher=request.getRequestDispatcher("http://www.google.com");
//		requestDispatcher.forward(request, response);
//		response.sendRedirect("http://www.google.com");
		
		Cookie cookie=new Cookie("Cookie", "Nothing");
		response.addCookie(cookie);
		Scanner scanner=new Scanner(System.in);
		int a=scanner.nextInt();
		
//		cookie.setMaxAge(0);
//		response.addCookie(cookie);
	}
}