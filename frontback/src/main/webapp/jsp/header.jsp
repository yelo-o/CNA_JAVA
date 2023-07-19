<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%// String contextPath = request.getContextPath(); %>
<header>
	<h1>
		<a class="logo" href="<c:out value="${contextPath}"/>/jsp/layout.jsp">스타벅스코리아</a>
	</h1>
	<nav>
		<ul>
		<c:set var="loinedId" value="${sessionScope.loginedId}"/>
		<c:choose>
			<c:when test="${empty loginedId}">
				<li><a href="<c:out value="${contextPath}"/>/jsp/login.jsp">로그인</a></li>
				<li><a href="<c:out value="${contextPath}"/>/jsp/signup.jsp">가입</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="logout">로그아웃</a></li>
			</c:otherwise>
		</c:choose>
			<li><a href="productlist">상품목록</a></li>
			<li><a href="cartlist">장바구니목록</a></li>
			<li><a href="orderlist">주문목록</a></li>
		</ul>
	</nav>
</header>
