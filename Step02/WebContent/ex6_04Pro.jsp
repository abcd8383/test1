<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td>글번호</td>
			<td>글제목</td>
			<td>글내용</td>
		</tr>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
		
		for(int i=num; i>0; i--){
			%>
			<tr>
				<td>
					<%=i%>
				</td>
				<td>제목<%=i%></td>
				<td>내용<%=i%></td>
			</tr>
			<%	
		}
	%>
	</table>
</body>
</html>