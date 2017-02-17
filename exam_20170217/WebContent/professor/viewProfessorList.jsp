<%--전체 교수 정보를 출력하는 JSP--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSTL 설정 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 교수 정보 출력</title>
</head>
<body>
	<h3 align="center">전체 교수 정보</h3>
	
	<p align="center"><a href="<c:url value="addProfessorForm"/>"> 교수 추가 </a><br/></p>
	
	<table align="center" border="1">
		<tr>
			<td width="150">번호</td>
			<td width="200">이름</td>
		</tr>
		<%--
	STL의 <c:forEach ..> 를 이용해서 ProfessorService의 viewProfessorList의 3에서
	전송한 교수 리스트의 교수번호, 교수 이름을 출력
	 --%>
		<c:forEach items="${PROFESSOR_LIST}" var="professor">
			<tr>
				<td>
					<a href="<c:url value="viewProfessor?profno=${professor.profno}"/>"> ${professor.profno} </a>
				</td>
				<td>${professor.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>