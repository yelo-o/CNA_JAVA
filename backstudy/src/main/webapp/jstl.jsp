<%@ page import="com.my.product.dto.Product" %>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jstl.jsp</title>
</head>
<body>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${empty param.id}">
	아이디없습니다
</c:if>

<hr>
<%-- 현재 사용중인 JSP 전용객체(PageContext)의 attribute 추가--%>
<c:set var="opt" value="hello"></c:set>
<c:set var="opt" value="${param.opt}"></c:set>
<c:choose>
	<c:when test="{opt=='add'}">
		등록작업을 선택하셨습니다
	</c:when>
	<c:when test="{opt=='remove'}">
		삭제작업을 선택하셨습니다
	</c:when>
	<c:otherwise>
		작업을 선택하세요<br>
		<a href="jstl.jsp?opt=add">등록</a>&nbsp;&nbsp;
		<a href="jstl.jsp?opt=remove">삭제</a>
	</c:otherwise>
</c:choose>

<hr>
<c:forEach begin="1" end="10" var="i">
	<c:out value="${i}"/>
</c:forEach>
<hr>

<%
List<Product> list = new ArrayList<>();
list.add(new Product("C0001", "상1", 100));
list.add(new Product("C0002", "상2", 200));
list.add(new Product("C0003", "상3", 300));
request.setAttribute("list", list);
%>
<c:forEach items="${requestScope.list}" var="p">
	${p.prodNo}:${p.prodName}:${p.prodPrice}<br>
</c:forEach>
</body>
</html>