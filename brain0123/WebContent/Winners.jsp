<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
String winners[] = new String[3];
winners[0] = "jane";
winners[1]="john";
winners[2] ="david";

request.setAttribute("winners", winners);
RequestDispatcher dispatcher = request.getRequestDispatcher("WinnersView.jsp"); // ���� �� �����ϰ� �ٷ� �������� �������
dispatcher.forward(request, response);

%>