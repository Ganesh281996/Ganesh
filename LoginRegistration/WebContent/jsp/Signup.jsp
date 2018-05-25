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
<h1>Register</h1>
<form action="signupcontroller" method="post">
UserName : <input type="text" name="UserName"><br>
Gender : 
Male <input type="radio" name="Gender" value="Male">
Female <input type="radio" name="Gender" value="Female"><br>
Date Of Birth : <input type="text" name="DateOfBirth"><br>
Email : <input type="text" name="Email"><br>
Phone : <input type="text" name="Phone"><br>
Address : <textarea name="Address"></textarea><br>
Password : <input type="password" name="Password"><br>
<input type="submit" value="Submit">  <input type="reset" value="Reset">
</form>
</body>
</html>