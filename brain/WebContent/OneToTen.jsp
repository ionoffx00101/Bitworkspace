<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
�ͽ��������� ����� ���<br>
<%for(int cnt=1; cnt<=10;cnt++){ %>
<%=cnt %>
<%} %>
<br>
out ���� ������ ����� ���<br>
<% for(int cnt=1; cnt<=10;cnt++){
	out.println(cnt);
} %>
<br>
<% PrintWriter writer = response.getWriter();
for(int cnt=1; cnt<=10;cnt++){
writer.println(cnt);
}
%>
</body>
</html>