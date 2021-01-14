<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>forward 액션태그</h2>
	<form method="post" action="forwardTest.jsp">
	아이디:<input type="text" name="id"><br>
	취미:
	<select name="hobby">
		<option value="WOW">WOW</option>
		<option value="만화보기">만화보기</option>
		<option value="스타2-군단의심장">스타2-군단의심장</option>
	</select><br>
	<button>입력완료</button>		
	</form>
</body>
</html>