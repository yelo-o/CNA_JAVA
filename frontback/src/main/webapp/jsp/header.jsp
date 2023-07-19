<%@ page contentType="text/html; charset=UTF-8"%>
<% String contextPath = request.getContextPath(); %>
<header>
	<h1>
		<a class="logo" href="<%=contextPath %>/jsp/layout.jsp">스타벅스코리아</a>
	</h1>
	<nav>
		<ul>
			<%//로그인 성공되었다 세션속성명:loginedId, 값:로그인한아이디값
			String loginedId = (String) session.getAttribute("loginedId");
			if(loginedId == null) {
			%>
			<li><a href="<%=contextPath %>/jsp/login.jsp">로그인</a></li>
			<li><a href="<%=contextPath %>/jsp/signup.jsp">가입</a></li>
			<%}else{ %>
			<li><a href="logout">로그아웃</a></li>
			<%} %>
			
			<li><a href="productlist">상품목록</a></li>
			<li><a href="cartlist">장바구니목록</a></li>
			<li><a href="orderlist">주문목록</a></li>
		</ul>
	</nav>
</header>
