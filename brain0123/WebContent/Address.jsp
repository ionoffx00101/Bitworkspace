<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
HashMap<String,String> map = new HashMap<String,String>();
map.put("edgar", "boston");
map.put("thomas","nevada");
map.put("john","goodspring");
request.setAttribute("map", map);

RequestDispatcher dispatcher = request.getRequestDispatcher("AddressView.jsp");
dispatcher.forward(request, response);

%>