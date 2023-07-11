<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Exception e = (Exception) request.getAttribute("e");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>err.jsp</title>
</head>
<body>
<h1 style = "color:red"><%=e.getMessage() %></h1>

</body>
</html>