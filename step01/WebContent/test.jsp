<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	

<%!
	public String getGuGu(int n){
		String result="";
		for(int i=1; i<10; i++){
			result += n+"*"+i+"="+n*i+"<br>";
		}
		return result;
	}
%>
<%=getGuGu(3) %>
</body>
</html>