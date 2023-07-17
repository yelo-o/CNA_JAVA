<%@ page import="com.my.product.dto.Product" %>
<%@ page import="com.my.util.PageBean" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%String contextPath = request.getContextPath();// '/frontback' %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=2.0">
    <link rel="stylesheet" href="<%=contextPath%>/css/productlist.css">
    <link rel="stylesheet" href="<%=contextPath%>/css/layout.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script src="<%=contextPath%>/js/layoutjq.js"></script>
    <script src="<%=contextPath%>/js/productlistjq.js"></script>
</head>

<body>
    <jsp:include page="./header.jsp"/>

    <section>
    <%String msg = (String)request.getAttribute("msg");
	    if(msg!=null){ //상품목록검색 실패
    %> <h3>상품목록 검색 실패 : <%=msg%> </h3>
    <%
	    }else {
	    	//List<Product> list = (List)request.getAttribute("list");	
	    	PageBean<Product> pb = (PageBean<Product>)request.getAttribute("pagebean");
	    	int totalCnt = pb.getTotalCnt(); //총 상품수
	    	
    %>	
    <div class="productlist">
    <% for(Product p: pb.getList()){
    %>
      <div class="product <%=p.getProdNo()%>">
          <ul>
              <li>
                  <img src="<%=contextPath%>/images/<%=p.getProdNo()%>.jpg"
                  	 alt="<%=p.getProdNo()%>">
                  <span><%=p.getProdName()%></span>
              </li>
          </ul>
      </div>
    <%}//for %>
      </div>
        
      <div class="pagegroup">
            <%
           	int currentPage = pb.getCurrentPage();
			int totalPage = pb.getTotalPage();
			int startPage = pb.getStartPage();
			int endPage = pb.getEndPage();
			if(startPage > 1){
			%><span class="page<%=startPage-1%>">PREV</span>&nbsp;&nbsp;
			<%
			}
			for(int i=startPage; i<=endPage; i++){
			%><span class="page<%=i%>">[<%=i%>]</span>&nbsp;&nbsp;	
			<%}
			
			if(totalPage > endPage){
            %><span class="page<%=endPage+1%>">NEXT</span>
            <%} %>
      </div>
    <%}//else %>
    </section>

    <%@include file="./footer.jsp"%>


</body>

</html>