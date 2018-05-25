<%@page import="java.sql.ResultSet"%>
<%@page import="com.bridgelabz.model.UserOperation"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setDateHeader("Expires", 0);
response.setHeader("Pragma", "no-cache");
String email=(String)session.getAttribute("Email");
%>

<%if(session.getAttribute("Email")==null)
	{
		response.sendRedirect("home");
	}
else
{
%>

<%
UserOperation userOperation=new UserOperation(); 
ResultSet resultSet=userOperation.login((String)session.getAttribute("Email"), (String)session.getAttribute("Password"));
resultSet.next();
%>
<h1>Update</h1>
<form action="updatecontroller" method="post">
UserName : <input type="text" name="UserName" value=<%=resultSet.getString(1) %>><br>
Gender : 
<%String gender=resultSet.getString(2);
if(gender.equals("Male"))
{
%>
Male <input type="radio" name="Gender" value="Male" checked="checked"  disabled>
<input type="hidden" name="Gender" value="Male">
<% }
else
{
%>
Female <input type="radio" name="Gender" value="Female" checked="checked" disabled><br>
<input type="hidden" name="Gender" value="Female">
<%} %><br>
Date Of Birth : <input type="text" name="DateOfBirth" value=<%=resultSet.getString(3) %>><br>
Email : <input type="text" name="Email" value=<%=resultSet.getString(4) %> disabled><br>
Phone : <input type="text" name="Phone" value=<%=resultSet.getString(5) %>><br>
Address : <textarea name="Address"  ><%=resultSet.getString(6)%></textarea><br>
Password : <input type="password" name="Password" value=<%=resultSet.getString(7) %>><br>
<input type="submit" value="Submit">  <input type="reset" value="Reset">
</form>
<%} %>
</body>
</html>