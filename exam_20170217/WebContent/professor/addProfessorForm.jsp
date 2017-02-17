<%-- 교수 정보 입력 페이지 --%>    
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSTL 설정 --%>    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="<c:url value="addProfessor"/>" method="post">
교수 번호 : <input type="text" name="profno" size="8"/><br/>
교수 이름 : <input type="text" name="name" size="8"/><br/>
월급 :	 <input type="text" name="sal" size="8"/><br/>
성과급 : <input type="text" name="comm" size="8"/><br/>
입사일 : <input type="text" name="date" size="8" value="2017-02-17"/><br/>
전체 학과 리스트 : 
<select>
<c:forEach items="${deptList}" var="dept">
<option value="${dept.deptno}">${dept.dname}</option>
</c:forEach>
</select><br/><br/>
<input type="submit" value="추가" /> <input type="reset" value="리셋" />
</form><br/>
<a href="<c:url value="viewProfessorList"/>"> 교수 전체 리스트 </a><br/>
</body>
</html>