<%@page import="kr.bit.dto.MemberDto"%>
<%@page import="kr.bit.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	String id = (String)session.getAttribute("id");
	MemberDao dao = MemberDao.getInstance();
	MemberDto dto = dao.getMember(id);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script language="JavaScript">
	
	function updateInfoConfirm() {
		// pw 항목 체크
		// pw_check 항목 체크
		document.regForm.submit();
	}
</script>
</head>
<body>
	<form action="modifyOk.jsp" method="post" name="regForm">
		아이디 : <%= dto.getId() %><br />
		비밀번호 : <input type="password" name="pw" size="20"><br />
		비밀번호 확인 : <input type="password" name="pw_check" size="20"><br />
		이름 : <%= dto.getName() %><br />
		메일 : <input type="text" name="eMail" size="20" value="<%= dto.geteMail() %>"><br />
		주소 : <input type="text" name="address" size="50" value="<%= dto.getAddress() %>"><br />
		전화번호 : <input type="text" name="tel" size="20" value="<%= dto.getTel() %>"><br/>
		
		<input type="button" value="수정" onclick="updateInfoConfirm()">
		&nbsp;&nbsp;&nbsp; 
		<input type="reset" value="취소" onclick="javascript:window.location='login.jsp'">
	</form>
</body>
</html>
