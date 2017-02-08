<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교수조회</title>
</head>
<body>
	학번
	  ${professor.profno}
	  <br/> 
	   이름
	   ${professor.name}
	<br/>
	아이디
	${professor.userid}
	<br/>
	직급
	${professor.position}
	<br/>
	월급
	${professor.sal}
	<br/>
	성과급
	${professor.comm}
	<br/>
	입사일
	${professor.hiredate}
	<br/>
	학과명
	${professor.dept.dname}
	<br/>
	학과위치
	${professor.dept.loc}
	<br/>
	을 출력 
	
	
	<a href="ProfessorService?method=editProfessorForm&profno=${professor.profno}"> 
  	  		교수 수정
  	</a>
	
	
	
	
	
	 <a href="ProfessorService?method=viewProfessorList"> 
  	  		목록으로
  	</a>
</body>
</html>