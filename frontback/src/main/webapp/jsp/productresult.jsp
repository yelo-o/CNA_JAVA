<%@ page import="com.my.product.dto.Product" %>
<%@ page contentType="text/html; charset=UTF-8"%>
<%String contextPath = request.getContextPath();// '/frontback' %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=2.0">
    <link rel="stylesheet" href="<%=contextPath%>/css/product.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <%-- <script src="<%=contextPath%>/js/productjq.js"></script> --%>
</head>

<body>
    <div class="product_view">
    <%
    	Product p = (Product)request.getAttribute("Product");
    %>	
        <div class="product_view_pic">
            <img src="<%=contextPath%>/images/<%=p.getProdNo() %>.jpg">
        </div> <!--width 450px; float:left-->
        
        <div class="product_view_detail">
            <h4>
                <span class="ko"><%=p.getProdName() %></span>
                <span class="price"><%=p.getProdPrice() %>원</span>
            </h4>
            <fieldset>
                <legend class="hid">상세 정보</legend>
                <div class="product_view_info">
                    <div class="product_number">
                        <span>상품번호 : </span>
                        <span><%=p.getProdNo() %></span>
                    </div>
                    
                    <div class="product_name">
                        <span>상품명 : </span>
                        <span><%=p.getProdName() %></span>
                    </div>
                    
                    <div class="product_price">
                        <span>가격 : </span>
                        <span><%=p.getProdPrice() %></span>
                    </div>
                    <div class="">
                        <span>수량 : </span>
                        <input type="number" name="prod_count" value="1" placeholder="수량을 입력하세요">
                    </div>
                    
                    <button class="product_count" >장바구니 넣기</button>
                </div>

            </fieldset>
   		</div>
		
    </div>


</body>

</html>