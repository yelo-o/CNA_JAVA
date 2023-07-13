<%@ page import="com.my.product.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>el.jsp</title>
</head>
<body>
파라미터id가 없으면??<br>
request.getParemeter("id") = <%=request.getParameter("id") %><br>
el param.id = ${param.id}
${empty param.id? "아이디없음": param.id}
<hr>
<%
	Product p = new Product("C0001", "상품1", 1000);
	request.setAttribute("p", p);
%>
상품번호 : ${requestScope.p.prodNo}<br>
상품명 : ${requestScope.p.prodName}<br>
상품가격 : ${requestScope.p.prodPrice}
</body>
</html>