<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--addorderresult.jsp--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="msg" value="${requestScope.msg}"></c:set>
<c:choose>
	<c:when test="${!empty msg}">
		<c:out value="${msg}"/>
	</c:when>
	<c:otherwise>
		<c:out value="${msg}"/>
	</c:otherwise>
</c:choose>
