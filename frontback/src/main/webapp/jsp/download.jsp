<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>download.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<%=contextPath%>/js/downloadjq.js"></script>
</head>
<body>
<div style="width:50%; border:1px solid">
	<img>
</div>
<a href="#" class="txt">일반파일 다운로드</a>
<a href="#" class="img">이미지 다운로드</a>
</body>
</html>