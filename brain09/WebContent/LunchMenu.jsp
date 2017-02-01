<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String arr[] = { "บาน้", "ฤแ", "นไ" };
	request.setAttribute("menu", arr);
%>
<jsp:forward page="LunchMenuView.jsp" />