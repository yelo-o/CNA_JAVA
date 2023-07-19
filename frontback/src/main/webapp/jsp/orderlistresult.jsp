<%@page import="com.my.product.dto.Product"%>

<%@page import="com.my.order.dto.OrderLine"%>
<%@page import="com.my.order.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<link rel="stylesheet"  href="<c:out value="${contextPath}"/>/css/orderlist.css">
<div class="orderlist">
<h3>주문목록</h3>
<c:set var="msg" value="${requestScope.msg}"/>
<c:choose>
	<c:when test="${!empty msg}">
		<c:out value="${msg}"/>
	</c:when>
	<c:otherwise>
		<c:set var="list" value="${requestScope.list}"/>
		<table class="orderlist">
		<tr><th>주문번호</th><th>주문일자</th><th>상품번호</th><th>상품명</th><th>가격</th><th>수량</th></tr>
		<c:forEach items="${list}" var="info">
			<c:set var="orderNo" value="${info.orderNo}"/>
			<c:set var="orderDt" value="${info.orderDt}"/>
			<c:set var="lines" value="${info.lines}"/>
			<c:set var="linesSize" value="${lines.siez()}"/>
			<tr>
				<td rowspan="<c:out value="${linesSize}"/>"><c:out value="${orderNo}"/></td>
				<td rowspan="<c:out value="${linesSize}"/>"><c:out value="${orderDt}"/></td>
			<c:forEach items="${lines}" var="line">
			<c:set var="p" value="${line.orderP}"/>
			<c:set var="prodNo" value="${line.prodNo}"/>
			<c:set var="prodName" value="${line.prodName}"/>
			<c:set var="prodPrice" value="${line.prodPrice}"/>
			<c:set var="orderQuantity" value="${line.orderQuantity}"/>
			<td><c:out value="${prodNo}"/>
			<td><c:out value="${prodName}"/>
			<td><c:out value="${prodPrice}"/>
			<td><c:out value="${orderQuantity}"/>
			</c:forEach>
		    </tr>
		</c:forEach>
		</table>
	</c:otherwise>
</c:choose>
</div>