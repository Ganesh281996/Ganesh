package com.bridgelabz.filters;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class SignUpFilter implements Filter 
{
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		response.setContentType("text/html");
		Pattern pattern=null;
		Matcher matcher=null;
		PrintWriter out=null;
		RequestDispatcher requestDispatcher=null;
		boolean flag=true;
		out=response.getWriter();
		String name=request.getParameter("UserName");
		pattern=Pattern.compile("[a-zA-Z]+$");
		matcher=pattern.matcher(name);
		if(!matcher.matches())
		{
			out.println("Invalid Name<br>");
			flag=false;
		}
		
		String gender=request.getParameter("Gender");
		if(gender==null)
		{
			out.println("Select Gender<br>");
			flag=false;
		}
		
		String dateOfBirth=request.getParameter("DateOfBirth");
		pattern=Pattern.compile("^\\d{1,2}\\/\\d{1,2}\\/\\d{4}$");
		matcher=pattern.matcher(dateOfBirth);
		if(!matcher.matches())
		{
			out.println("Invalid Date Of Birth<br>");
			flag=false;
		}
		
		String email=request.getParameter("Email");
		pattern=Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
		matcher=pattern.matcher(email);
		if(!matcher.matches())
		{
			out.println("Invalid Email<br>");
			flag=false;
		}
		
		String phone=request.getParameter("Phone");
		pattern=Pattern.compile("[0-9]{10}+$");
		matcher=pattern.matcher(phone);
		if(!matcher.matches())
		{
			out.println("Invalid Phone Number<br>");
			flag=false;
		}
		
		String address=request.getParameter("Address");
		if(address.equals(""))
		{
			flag=false;
			out.println("Enter Address<br>");
		}
		
		String password=request.getParameter("Password");
		pattern=Pattern.compile("^[a-zA-Z]\\w{3,14}$");
		matcher=pattern.matcher(password);
		if(!matcher.matches())
		{
			out.println("Invalid Password<br>");
			flag=false;
		}
		
		if(!flag)
		{
			requestDispatcher=request.getRequestDispatcher("Signup.jsp");
			requestDispatcher.include(request, response);
		}
		else
		{
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{
		
	}
	
	public void destroy() 
	{
		
	}
}