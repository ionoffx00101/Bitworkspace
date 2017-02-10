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
	<form action="ProfessorService"  method="post">
	<input type="hidden"  name="method"  value="editProfessor"/>
	
	학번
	<input type="text" value="${PROFESSOR.profno}" name="profno"  readonly="readonly"/><br/>
	이름
	<input type="text" value="${PROFESSOR.name}" name="name"/><br/>
	아이디
	<input type="text" value="${PROFESSOR.userid}" name="userid"/><br/>
	직급
	<input type="text"
	   value="${PROFESSOR.position}" name="position"/>
	<br/>
	월급
	<input type="text"
	   value="${PROFESSOR.sal}" name="sal"/>
	<br/>
	성과급
	<input type="text"
	   value="${PROFESSOR.comm}" name="comm"/>
	<br/>
	입사일
	<input type="text"
	   value="${PROFESSOR.hiredate}" name="hiredate"/>
	<br/>
	<select name="deptno">
		<c:forEach items="${DEPT_LIST}" var="DEPT">
			<option value="${DEPT.deptno}"
			<%--
			  DEPT의 학과번호와 교수의 학과번호가 같으면 해당 학과가 같다면해당 항목이 선택되도록함
			 <c:if test="${DEPT.deptno==PROFESSOR.dept.deptno}">
			   selected="selected" 
			 </c:if>
			 %>
			--%>
			<c:if test="${DEPT.deptno==PROFESSOR.dept.deptno }">
				selected="selected"
			</c:if>
			>${DEPT.dname}</option>
		</c:forEach>
	</select>
	<br/>
 	<input type="submit"  value="학생수정"><br/>
 	<input type="reset" value="입력취소"/>
 	</form>
 <br/>
	<a href="ProfessorService?method=viewProfessorList"> 
  	  		목록보기
  	</a>
  	<br/>
</body>
</html>