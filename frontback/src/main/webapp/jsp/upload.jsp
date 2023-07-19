<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
<script src="<%=contextPath%>/js/uploadjq.js"></script>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="<%=contextPath%>/upload">
	<input type="text" name="t" value="tValue"><br>
	<input type="file" name="f1" multiple>
	<button>첨부하기</button>
</form>

</body>
</html>