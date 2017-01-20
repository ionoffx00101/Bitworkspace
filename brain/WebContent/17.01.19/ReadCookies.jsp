<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% Cookie[] cookies = request.getCookies();  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
name	: <%=getCookieValue(cookies,"name") %><br>
gender	: <%=getCookieValue(cookies,"gender") %><br>
age 	: <%=getCookieValue(cookies,"age") %><br>
</body>
</html>
<%!private String getCookieValue(Cookie[] cookies, String name)
	{
		if (cookies == null)
		{
			return null;
		}
		for (Cookie cookie : cookies)
		{
			if (cookie.getName().equals(name))
			{
				return cookie.getValue();
			}
		}
		return null;
	}%>