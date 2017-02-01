<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	String str = request.getParameter("num");
	int num = Integer.parseInt(str);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>소수</title>
</head>
<body>
	<%
		int arr[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
		for (int cnt = 0; cnt < num; cnt++)
		{
			out.print(arr[cnt]);
		}
	%>
</body>
</html>