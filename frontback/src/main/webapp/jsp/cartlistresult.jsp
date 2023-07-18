<%@page import="com.my.product.dto.Product"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null){
%><%=msg %>	
<%
  return;
}
Map<Product, Integer> resultCart = (Map)request.getAttribute("resultcart");
%>
<%String contextPath = request.getContextPath(); //  '/frontback' %>
<link rel="stylesheet" href="<%=contextPath %>/css/cartlist.css">
<script src="<%=contextPath %>/js/cartlistjq.js"></script>
<div class="cartlist">
<table>
	<tr><td>상품번호</td><td>상품명</td><td>상품가격</td><td>수량</td></tr>
<%for(Product p: resultCart.keySet()){
%>
<tr>
  <td><%=p.getProdNo() %></td>
  <td><%=p.getProdName() %></td>
  <td><%=p.getProdPrice() %></td>
  <td><%=resultCart.get(p) %></td>
</tr>
<%}
%>
</table>
</div>
<button>주문하기</button>