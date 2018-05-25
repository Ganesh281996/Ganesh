<%@page import="java.sql.ResultSet"%>
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
<%
ResultSet resultSet=(ResultSet)request.getAttribute("Users");
%>
<table align="center" title="Users" style="border: dashed ; border-color: black;">
<tr>
<th>Name</th>
<th>Gender</th>
<th>Date Of Birth</th>
<th>Email </th>
<th>Phone Number</th>
<th>Address</th>
<th>Password</th>
</tr>
<%
while(resultSet.next())
{
%>
<tr>
<td><%=resultSet.getString(1) %></td>
<td><%=resultSet.getString(2) %></td>
<td><%=resultSet.getString(3) %></td>
<td><%=resultSet.getString(4) %></td>
<td><%=resultSet.getString(5) %></td>
<td><%=resultSet.getString(6) %></td>
<td><%=resultSet.getString(7) %></td>
<td><a href="deletecontroller?Email=<%=resultSet.getString(4)%>&Password=<%=resultSet.getString(7)%>">Delete</a></td>
</tr>
<%}%>
</table>
<a href="home">Home</a>
</body>
</html>