<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/login.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/loginjq.js"></script>
    </head>

    <body>
		<button>돌보미로 로그인</button>
		<br><br>
		<button>보호자로 로그인</button>
    </body>

</html>