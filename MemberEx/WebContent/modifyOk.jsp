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
		alert("�������� �Ǿ����ϴ�.");
		document.location.href="mainpage.jsp";
	</script>
<%
	} else {
%>
	<script language="javascript">
		alert("�������� ���� �Դϴ�.");
		history.go(-1);
	</script>
<%
	}
%>    
