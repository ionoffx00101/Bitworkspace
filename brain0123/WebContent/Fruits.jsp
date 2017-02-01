<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
ArrayList<String> items = new ArrayList<String>();
items.add("citroen");
items.add("appel");
items.add("kaas");

request.setAttribute("fruit", items);
RequestDispatcher dispatcher = request.getRequestDispatcher("FruitsView.jsp"); // 위에 식 실행하고 바로 이페이지 열어버림
dispatcher.forward(request, response);

%>