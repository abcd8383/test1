<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application - 1</title>
</head>
<body>
	<%
		application.setAttribute("app_num", 777);
	%>
	
	<%=application.getServerInfo()%>
	<%=application.getRealPath("applicaion_1.jsp")%>
	<a href="application_2.jsp">다음 페이지</a>
</body>
</html>