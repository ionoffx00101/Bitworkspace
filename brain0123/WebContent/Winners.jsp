<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String winners[] = new String[3];
winners[0] = "jane";
winners[1]="john";
winners[2] ="david";

request.setAttribute("winners", winners);
RequestDispatcher dispatcher = request.getRequestDispatcher("WinnersView.jsp"); // 위에 식 실행하고 바로 이페이지 열어버림
dispatcher.forward(request, response);

%>