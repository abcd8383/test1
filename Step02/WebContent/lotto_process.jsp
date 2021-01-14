<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int lotto[] = new int[6];
	int num = Integer.parseInt(request.getParameter("num"));
	String number="<tr>";
	
	for(int a=0; a<num; a++){
		for(int i=0; i<6; i++){
			lotto[i] = (int)(Math.random()*45)+1;
			
			for(int j=0; j<i; j++){
				if(lotto[i]==lotto[j]){
					i--;
					break;
				}
			}
		}
		for(int i=0; i<6; i++){
			number+="<td>"+lotto[i]+"</td>";
		}
		number+="</tr><tr>";
	}
	request.setAttribute("str", number);
	RequestDispatcher dispatcher = request.getRequestDispatcher("lotto_result.jsp");
	dispatcher.forward(request, response);
%>