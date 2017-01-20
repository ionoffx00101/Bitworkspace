<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%
	String str1 = request.getParameter("num1");
	String str2 = request.getParameter("num2");

	int num1 = Integer.parseInt(str1);
	int num2 = Integer.parseInt(str2);

	request.setAttribute("sum", new Integer(num1 + num2));
	request.setAttribute("difference", new Integer(num1 - num2));
	request.setAttribute("product", new Integer(num1 * num2));
	request.setAttribute("quotient", new Integer(num1 / num2));
	RequestDispatcher dispatcher = request.getRequestDispatcher("FourRulesResult.jsp");
	dispatcher.forward(request, response);
%>