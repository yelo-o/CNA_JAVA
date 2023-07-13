<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>first.jsp</title>
</head>
<body>
<%int i; //지역변수 선언%>
<%i=99; %>
scriptlet을 활용 i=<%out.print(i); %>
<hr>
expression을 활용 i=<%=i%>

<%!int i; //멤버변수 선언%>
_jspService()의 지역변수 i=<%=i %><br>
멤버변수 i=<%=this.i %>

<hr>
<h3>include지시자를 이용한 포함</h3>
<%@include file="./html/lifecycle.html" %>
<hr>
<h3>include 태그를 이용한 포함</h3>
<jsp:include page="./html/lifecycle.html"></jsp:include>

</body>
</html>