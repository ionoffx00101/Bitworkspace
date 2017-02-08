<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교수 수정</title>
</head>
<body>
 <%--수정 하려는 교수 정보를 수정이 가능하도록 출력하고 전체 학과 리스트 출력   editStudentForm.jsp 참조--%>
교수의 학번
     <input type="text"
	   value="${professor.profno}"/>
	   <br/>
	   이름
	   <input type="text"
	   value="${professor.name}"/>
	<br/>
	아이디
	<input type="text"
	   value="${professor.userid}"/>
	<br/>
	직급
	<input type="text"
	   value="${professor.position}"/>
	<br/>
	월급
	<input type="text"
	   value="${professor.sal}"/>
	<br/>
	성과급
	<input type="text"
	   value="${professor.comm}"/>
	<br/>
	입사일
	<input type="text"
	   value="${professor.hiredate}"/>
	<br/>
	
	<select> 
  <c:forEach  items="${deptList}"
     var="dept">
     <option>${dept.dname}</option>
 </c:forEach>
 </select>
  
<a href="ProfessorService?method=viewProfessorList"> 
  	  		목록으로
  	</a>
</body>
</html>