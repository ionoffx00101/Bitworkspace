<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	Cookie cookie = new Cookie("name", "jane");
	response.addCookie(cookie);
	cookie = new Cookie("gender", "female");
	response.addCookie(cookie);
	cookie = new Cookie("age", "28");
	response.addCookie(cookie);
%><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
크키 설정
</body>
</html>