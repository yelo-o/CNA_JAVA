<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--addorderresult.jsp--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String msg = (String)request.getAttribute("msg");
if(msg != null){//로그인 안된 경우, 장바구니가 비어있는 경우
%><%=msg%>
<%
	return;
}
%>
<%=request.getAttribute("status")%>