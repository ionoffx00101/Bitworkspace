<%@page import="kr.bit.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>

<jsp:useBean id="dto" class="kr.bit.dto.MemberDto" scope="page" />
<jsp:setProperty name="dto" property="*" />

<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	
	MemberDao dao = MemberDao.getInstance();
	int nReturn = dao.updateMember(dto);
	
	if(nReturn == 1) {
%>
	<script language="javascript">
		alert("정보수정 되었습니다.");
		document.location.href="mainpage.jsp";
	</script>
<%
	} else {
%>
	<script language="javascript">
		alert("정보수정 실패 입니다.");
		history.go(-1);
	</script>
<%
	}
%>    
