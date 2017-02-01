<%@page import="kr.bit.dto.MemberDto"%>
<%@page import="kr.bit.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	MemberDao dao = MemberDao.getInstance();
	boolean check = dao.memberCheck(id, pw);
	if(check == false) {
%>
		<script language="javascript">
			alert("아이디/비밀번호가 잘못되었습니다.");
			history.go(-1);
		</script>
<%
	} else if(check == true) {
		MemberDto dto = dao.getMember(id);
		
		if(dto == null) {
%>
		<script language="javascript">
			alert("존재하지 않는 회원 입니다.");
			history.go(-1);
		</script>
<%
		} else {
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMember", "yes");
			response.sendRedirect("mainpage.jsp");
		}
	}
%>
