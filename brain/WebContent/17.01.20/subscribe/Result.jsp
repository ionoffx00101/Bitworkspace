<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
	// �� ���������� �Ķ���ͷ� �ѱ� ����Ʈ �� �޾ƿ���
	String result = request.getParameter("RESULT");
	// �ߵ�� ������ üũ��
	session.getId();
	String id = (String) session.getAttribute("id");
	String pw = (String) session.getAttribute("pw");
	String name = (String) session.getAttribute("name");
	String address = (String) session.getAttribute("address");
	String phone = (String) session.getAttribute("phone");
	String email = (String) session.getAttribute("email");
	session.invalidate();
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
	<%
		if (result.equals("SUCCESS"))
		{
			out.println("���Ե�");
		} else
		{
			out.println("���Ծȵ�");
		}
	%>
	<br>
	<%=id%><br>
	<%=pw%><br>
	<%=name%><br>
	<%=address%><br>
	<%=phone%><br>
	<%=email%><br>

</body>
</html>