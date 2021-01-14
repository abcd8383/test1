<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 선언문 -->
<%!
	//필드와 메서드를 작성
	String message="선언문 메세지";
	public String getMessage(){
		return message;
	}
%>
<!-- 표현식 -->
선언문 필드 테스트 : <%=message %><br>
선언문 메서드 테스트 : <%= getMessage() %>
<%
	int num=Integer.parseInt(request.getParameter("num"));
	String msg = request.getParameter("msg");
	%>
스크립트릿 테스트:<%=num %>
스크립트릿 테스트:<%=msg %>
</body>
</html>