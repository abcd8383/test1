<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단 출력</title>
</head>
<body>
	
	<%
		int dan=Integer.parseInt(request.getParameter("dan"));
		response.getWriter().println("받아온데이터 : "+dan);
		response.getWriter().println("<h2>"+dan+"</h2>");
 		for(int i=1; i<=9;i++){
	%>
 			<p> <%=dan%>*<%=i %>=<%=dan*i %></p>
 	<%
		} 
	%>
	
</body>
</html>








