<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=2.0">
        <!-- <meta name="viewport" content="width=device-width"> -->
        <title>레이아웃</title>
        <link rel="stylesheet" href="../css/layout.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
        <script src="../js/layoutjq.js"></script>

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