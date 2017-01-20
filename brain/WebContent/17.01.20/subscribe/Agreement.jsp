<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	// 전 페이지에서 파라미터를 통해 보낸 값들을 받는다
	request.setCharacterEncoding("euc-kr");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");

	// 받아 온 값을 세션에 넣어준다
	session.setAttribute("address", address);
	session.setAttribute("phone", phone);
	session.setAttribute("email", email);
	
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	약관
	<br>
	<br> ------------------
	<br> 1. 약관 읽음?
	<br> 2. 동의 안하면 가입못함
	<br> 3. 규칙어기면 호온나
	<br> ------------------
	<br>
	<form action="Subscribe.jsp" method="post">
		동의 함?
		<input type="radio" name="agree" value="agree">
		<input type="radio" name="agree" value="disagree" checked="checked">
		<br>
		<input type="submit" value="ok">
	</form>
	
</body>
</html>