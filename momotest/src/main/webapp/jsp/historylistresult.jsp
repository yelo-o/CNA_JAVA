<%@page import="com.momo.util.PageBean" %>
<%@page import="com.momo.customer.dto.History" %>
<%@page import="com.momo.customer.dto.Histories" %>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page contentType="text/html;charset=UTF-8" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="<c:out value="${contextPath}"/>/css/historylist.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
  <script src="<c:out value="${contextPath}"/>/js/historylistjq.js"></script>
</head>

<body>
<h3>히스토리 조회 목록</h3>
<%
//History h1 = new History(1, "s1", "o1", 0, 0);
//History h2 = new History(2, "s2", "o2", 1, 0);
//History h3 = new History(3, "s3", "o3", 0, 1);
//Histories histories = new Histories();  
//List<History> hList = new ArrayList<History>();
//hList.add(histories.getH1());
//hList.add(histories.getH2());
//hList.add(histories.getH3());
//hList.add(h1);
//hList.add(h2);
//hList.add(h3);
%>

<c:set var="hList" value="${requestScope.list}"/>
<hr>
<table class="historylist" style="border: 1px solid;">
<tr><th>히스토리번호</th><th>돌보미id</th><th>보호자id</th><th>유저타입</th><th>현황</th><th>승인버튼</th></tr>

<c:forEach items="${hList}" var="list">
<tr>
<td>${list.historyNo}</td>
<td>${list.sitterId}</td>
<td>${list.ownerId}</td>
<td>
	<c:set var="userType" value="${list.userType}" />
	<c:if test="${userType == 0}">
		돌보미
	</c:if>
	<c:if test="${userType == 1}">
		보호자
	</c:if>
</td>
<td>${list.status}</td>
<td><button>승인</button>	<button>거절</button></td>
</tr>
</c:forEach>
</table>

	
</body>

</html>