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

public class LoginFilter implements Filter 
{
	public void destroy() 
	{
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		response.setContentType("text/html");
		Pattern pattern=null;
		Matcher matcher=null;
		PrintWriter out=response.getWriter();
		boolean flag=true;
		RequestDispatcher requestDispatcher=null;
		
		String email=request.getParameter("Email");
		pattern=Pattern.compile("^\\w+@[a-zA-Z_]+?\\.[a-zA-Z]{2,3}$");
		matcher=pattern.matcher(email);
		if(!matcher.matches())
		{
			out.println("Invalid Email<br>");
			flag=false;
		}
		
		String password=request.getParameter("Password");
		pattern=Pattern.compile("^[a-zA-Z]\\w{3,14}$");
		matcher=pattern.matcher(password);
		if(!matcher.matches())
		{
			out.println("Invalid Password<br>");
			flag=false;
		}
		
		if(flag)
		{
			chain.doFilter(request, response);
		}
		else
		{
			requestDispatcher=request.getRequestDispatcher("login");
			requestDispatcher.include(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException 
	{

	}
}