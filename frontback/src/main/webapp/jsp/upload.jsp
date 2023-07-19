<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String contextPath = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>upload.jsp</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="<%=contextPath%>/upload">
	<input type="text" name="t" value="tValue">
	<input type="file" name="f1" multiple>
	<button>첨부하기</button>
</form>

</body>
</html>