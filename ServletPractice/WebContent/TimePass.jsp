<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="TimePassServlet">
<input type="text" name="Nothing">
<input type="submit">
</form>
<input type="text" name="nametwo">
</body>
<script type="text/javascript">
var a=document.getElementsByName("nametwo").value;
//alert(a);
console.log(a);
</script>
</html>
