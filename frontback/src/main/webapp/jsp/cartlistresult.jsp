<%@page import="com.my.product.dto.Product"%>
<%@page import="java.util.Map"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="msg" value="${requestScope.msg}"></c:set>
<c:choose>
	<c:when test="${!empty msg}">
		<c:out value="${msg}"/>
	</c:when>
	<c:otherwise>
		<c:set var="resultCart" value="${requestScope.resultcart}"/>
		<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
		<link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/cartlist.css">
		<script src="<c:out value="${contextPath}"/>/js/cartlistjq.js"></script>
		<div class="cartlist">
			<h3>장바구니</h3>
			<table>
				<tr><td>상품번호</td><td>상품명</td><td>상품가격</td><td>수량</td></tr>
				<c:forEach items="${resultCart}" var="item">
					<c:set var="p" value="${item.key}"/>
					<tr>
					  <td><c:out value="${p.prodNo}"/></td>
					  <td><c:out value="${p.prodName}"/></td>
					  <td><c:out value="${p.prodPrice}"/></td>
					  <td><c:out value="${item.value}"/></td>
					</tr>
				</c:forEach>
			</table>
			</div>
			<button>주문하기</button>
	</c:otherwise>
</c:choose>
