<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	// �� ���������� �Ķ���͸� ���� ���� ������ �޴´�
	request.setCharacterEncoding("euc-kr");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");

	// �޾� �� ���� ���ǿ� �־��ش�
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
	���
	<br>
	<br> ------------------
	<br> 1. ��� ����?
	<br> 2. ���� ���ϸ� ���Ը���
	<br> 3. ��Ģ���� ȣ�³�
	<br> ------------------
	<br>
	<form action="Subscribe.jsp" method="post">
		���� ��?
		<input type="radio" name="agree" value="agree">
		<input type="radio" name="agree" value="disagree" checked="checked">
		<br>
		<input type="submit" value="ok">
	</form>
	
</body>
</html>