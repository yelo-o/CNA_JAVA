<%@page import="java.io.FileNotFoundException"%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.io.FileInputStream" %>
<%@page import="java.util.Scanner"%>
<%@page buffer="1024kb" %>
<%@page errorPage="err1.jsp" %> <%--현재페이지에서 예외가 발생하면 err1.jsp로 forward하라(try&catch 안해도 됨) --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>directive.jsp</title>
</head>
<body>
<%for(int i=1; i<=100; i++){
%><span><%=i%></span>
<%}%>

<%
FileInputStream fis = null;
String fileName = "nonexist.txt"; //"a.txt"
String fileRealPath = this.getServletContext().getRealPath(fileName);
fis = new FileInputStream(fileRealPath);
Scanner sc = new Scanner(fis);
/*
try{
  fis = new FileInputStream(fileRealPath); //FileNotFoundException 발생 예상
  Scanner sc = new Scanner(fis);
} catch(FileNotFoundException e) {
	RequestDispatcher rd;
	rd = request.getRequestDispatcher("err.jsp");
	request.setAttribute("e", e);
	rd.forward(request, response);
	*/
%> <%--=e.getMessage()--%>
<%
/* } */
%>


</body>
</html>