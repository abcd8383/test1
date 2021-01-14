<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	tr,td{
		border: 1px solid black;
	}
</style>
</head>
<body>
	<%
		String str = (String)request.getAttribute("str");
	%>
	<table>
	<%=str %>
	</table>
</body>
</html>