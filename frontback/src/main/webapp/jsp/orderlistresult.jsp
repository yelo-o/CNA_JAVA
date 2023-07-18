<%@page import="com.my.product.dto.Product"%>

<%@page import="com.my.order.dto.OrderLine"%>
<%@page import="com.my.order.dto.OrderInfo"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%String contextPath = request.getContextPath(); //  '/frontback' %>
<link rel="stylesheet"  href="<%=contextPath %>/css/orderlist.css">
<div class="orderlist">
<h3>주문목록</h3>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null){
%><%=msg%>
<%
  return;
}
List<OrderInfo> list = (List)request.getAttribute("list");
%>    
<table class="orderlist">
<tr><th>주문번호</th>
    <th>주문일자</th>
    <th>상품번호</th>
    <th>상품명</th>
    <th>가격</th>
    <th>수량</th>
</tr>
<%
for(OrderInfo info: list){
	int orderNo = info.getOrderNo();
	java.util.Date orderDt = info.getOrderDt();
	List<OrderLine> lines = info.getLines();
	int linesSize = lines.size();
%>	
<tr><td rowspan="<%=linesSize%>"><%=orderNo%></td>
    <td rowspan="<%=linesSize%>"><%=orderDt %></td>
    
<%	for(OrderLine line: lines){
		Product p = line.getOrderP();
		String prodNo = p.getProdNo();
		String prodName = p.getProdName();
		int prodPrice = p.getProdPrice();
		int orderQuantity = line.getOrderQuantity();
%> <td><%=prodNo %></td>
   <td><%=prodName %></td>
   <td><%=prodPrice %></td>
   <td><%=orderQuantity %></td>
   </tr>
<%		
	}
}
%>
</table>
</div>