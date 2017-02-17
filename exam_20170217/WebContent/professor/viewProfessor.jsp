<%--  교수 1명 조회 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSTL 설정 --%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교수 정보</title>
</head>
<body>
	<h3>교수 정보</h3>
	<%--
	EL을 이용해서 ProfessorService의 viewProfessor() 메서드의 3에서 
	전송한 교수의 교수번호, 교수이름,월급,성과급 출력
	 --%>
	교수번호 : ${ PROFESSOR.profno }<br/>
	이름 : ${ PROFESSOR.name }<br/>
	월급 : ${ PROFESSOR.sal }<br/>
	성과급 : ${ PROFESSOR.comm }<br/>
	
	<a href="<c:url value="viewProfessorList"/>"> 교수 전체 리스트 </a><br/>
	<a href="<c:url value="addProfessorForm"/>"> 교수 추가 </a><br/>
</body>
</html>