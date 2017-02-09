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
<%--
	학번
	  ${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.profno}
	  <br/>
	  --%>
	교수번호:${PROFESSOR.profno}<br/>
	<%--  
	   이름
	   ${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.name}
	<br/>
	--%>
	이름:${PROFESSOR.name}<br/>
	 
	<%--
	아이디
	${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.userid}
	<br/>
	--%>
	아이디:${PROFESSOR.userid}<br/>
	<%--
	직급
	${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.position}
	<br/>
	--%>
	직급:${PROFESSOR.position}<br/>
	<%--
	월급
	${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.sal}
	<br/>
	--%>
	월급:${PROFESSOR.sal}<br/>
	
	<%--
	성과급
	${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.comm}
	<br/>
	--%>
	성과급:${PROFESSOR.comm}<br/>
	<%--
	입사일
	${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.hiredate}
	<br/>
	--%>
	입사일:${PROFESSOR.hiredate}<br/>
	<%--
	학과명
	${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.dept.dname}
	<br/>
	--%>
	학과명:${PROFESSOR.dept.dname}<br/>
	
	<%--
	학과위치
	${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.dept.loc}
	<br/>
	을 출력 
	--%>
	학과위치:${PROFESSOR.dept.loc}<br/>
	<%--
	<a href="ProfessorService?method=editProfessorForm&profno=${ProfessorService의 viewProfessor메서드에서 설정한 JSP에서 사용할 Professor객체의 이름.profno}"> 
  	  		교수 수정
  	</a>
	
	--%>
	
	<a href="ProfessorService?method=editProfessorForm&profno=${PROFESSOR.profno}"> 
  	  		교수 수정
  	</a>
  	<br/>
  	<a href="ProfessorService?method=removeProfessor&profno=${PROFESSOR.profno}"> 
  	  		교수 삭제
  	</a>
	<br/>
	<a href="ProfessorService?method=viewProfessorList"> 
  	  		목록보기
  	</a>
  	<br/>
</body>
</html>