<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
ArrayList<String> items = new ArrayList<String>();
items.add("citroen");
items.add("appel");
items.add("kaas");

request.setAttribute("fruit", items);
RequestDispatcher dispatcher = request.getRequestDispatcher("FruitsView.jsp"); // ���� �� �����ϰ� �ٷ� �������� �������
dispatcher.forward(request, response);

%>