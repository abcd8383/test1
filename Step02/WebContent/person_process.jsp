<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="obj.*" %>
<%
	String name = request.getParameter("id");
	int age = Integer.parseInt(request.getParameter("age"));
	
	Person p = new Person(name, age);
	System.out.println(p.toString());
	
	request.setAttribute("obj",p);
	/*페이지 이동 1과 동일한 방식. 응답 후 더이상 사요자의 요청을 받을 필요가 없을 때
	response.sendRedirect("person_result.jsp");*/
	//페이지 이동 2 - 계속해서 사용자의 응답을 받아야 할 때.
	RequestDispatcher dispatcher = request.getRequestDispatcher("person_result.jsp");
	dispatcher.forward(request, response);
%>
<!-- 
	페이지 이동 1 - 사용자의 요청이 전부 초기화됨.
<script>
	location.href="person_result.jsp";
</script>
 -->
 