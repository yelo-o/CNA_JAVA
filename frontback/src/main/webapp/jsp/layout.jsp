<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>레이아웃</title>
        <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/layout.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="<c:out value="${contextPath}"/>/js/layoutjq.js"></script>

    </head>

    <body>
        <%-- <%@ include file="./header.jsp" %> --%>
        <jsp:include page="./header.jsp"/>
        <section>
            <div>
                <article>드라이브스루 매장</article>
                <article>리저브 매장</article>
            </div>
            <aside>
                <ul>
                    <li>2023 SUMMER EVENT 안내</li>
                    <li>단체 및 기업 구매</li>
                </ul>
            </aside>
        </section>
        <%@include file="./footer.jsp"%>
        

    </body>
</html>