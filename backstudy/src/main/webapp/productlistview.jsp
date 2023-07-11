<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
List<String> list = (List<String>) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productlistview.jsp</title>
</head>
<body>
<ul>
<%for(String prodName : list) { %>
	<li><%=prodName %></li>
<% } %>
</ul>
</body>
</html>