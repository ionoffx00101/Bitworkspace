<%@page import="java.sql.Timestamp"%>
<%@page import="kr.bit.dao.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="dto" class="kr.bit.dto.MemberDto"/>
<jsp:setProperty name="dto" property="*" />
<%
	MemberDao dao = MemberDao.getInstance();
	if(dao.confirmMemberId(dto.getId()) == true) {
%>
		<script language="javascript">
			alert("아이디가 이미 존재 합니다.");
			history.back();
		</script>
<%
	} else {
		int nReturn = dao.insertMember(dto);
		if(nReturn == 1) {
			session.setAttribute("id", dto.getId());
%>
		<script language="javascript">
			alert("회원가입을 축하 합니다.");
			document.location.href="login.jsp";
		</script>
<%
	} else {
%>
		<script language="javascript">
			alert("회원가입에 실패했습니다.");
			document.location.href="login.jsp";
		</script>
<%
	}
}
%>
