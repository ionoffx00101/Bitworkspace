<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교수 추가</title>
</head>
<body>
	<form action="ProfessorService"  method="post">
	<input type="hidden"  name="method"  value="addProfessor"/>
 	번호 : <input type="text" name="profno"/><br>
 	이름 : <input type="text" name="name"/><br>
 	아이디 : <input type="text" name="userid"/><br>
 	직책 : <input type="text" name="position"/><br>
 	월급 : <input type="text" name="sal"/><br>
 	성과금 : <input type="text" name="comm"/><br>
 	입사일 : <input type="text" name="hiredate"/><br>
 	학과 리스트 : 
	<select name="deptno">
		<c:forEach items="${deptList}"
		    var="dept">
			<option value="${dept.deptno}">
			${dept.dname}
			</option>
		</c:forEach>
	</select>
	<br/>
 	<input type="submit"  value="학생추가"><br/>
 	<input type="reset" value="입력취소"/>
 	</form>
 <br/>
	<a href="ProfessorService?method=viewProfessorList"> 
  	  		목록보기
  	</a>
  	<br/>
</body>
</html>