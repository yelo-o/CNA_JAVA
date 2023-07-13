<%@ page import="com.my.product.dto.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
/*
request의 속성(이름:"p")값 얻기
속성값이 null이면 Product객체 생성 후 request의 속성(이름:"p", 값:Product객체) 추가
*/
Product p = (Product) request.getAttribute("p");
if(p == null){
	p = new Product();
	request.setAttribute("p", p);
}
--%>
<jsp:useBean id="p" class="com.my.product.dto.Product" scope="request"></jsp:useBean>

<%--p.setProdNo("C0001"); p.setProdName("이름값"); --%>
<%--
<jsp:setProperty name="no" value="C0001"></jsp:setProperty>
 --%>

</body>
</html>