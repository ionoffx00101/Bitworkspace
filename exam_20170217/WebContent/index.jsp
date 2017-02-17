<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSTL 설정 --%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교수관리</title>
</head>
<body>
	<a href="viewProfessorList.do">전체 교수 조회</a><br/>
	<a href="<c:url value="viewProfessorList"/>"> 교수 전체 리스트 </a>
</body>
</html>