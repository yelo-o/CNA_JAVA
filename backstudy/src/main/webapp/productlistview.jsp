<%@ page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
List<String> list = (List<String>) request.getAttribute("list");
--%>
<%--
<jsp:useBean id="list" class="java.util.ArrayList<String>" scope="request"></jsp:useBean>
--%>
<c:set var = "list" value="${requestScope.list}"></c:set>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>productlistview.jsp</title>
</head>
<body>
<%@include file="header.jsp"%>
<ul>

<%-- for(String prodName : list) { %>
	<li><%=prodName %></li>
<% } --%>

<c:forEach items="${list}" var="prodName">
	<li>${prodName}</li>
</c:forEach>

</ul>

<%@include file="footer.jsp"%>
</body>
</html>