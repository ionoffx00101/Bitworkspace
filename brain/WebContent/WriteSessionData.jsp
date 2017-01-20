<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
session.setAttribute("name", "daivd");
session.setAttribute("age", new Integer(21));
session.setAttribute("gender", "female");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
ㅇㅇ 됨<br>

<a href="<%=response.encodeURL("ReadSessionData.jsp")%>">read</a>
</body>
</html>