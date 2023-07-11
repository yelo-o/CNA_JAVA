<%@ page contentType="text/html; charset=UTF-8"%>
<%--예외처리 전용페이지이다 .java파일이 generated될 때
    _jspService() 내부에 exception 이라는 지역변수가 자동만들어진다--%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>err1.jsp</title>
</head>
<body>
<h1><%=exception.getMessage() %></h1>
</body>
</html>