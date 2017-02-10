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
	
	 <%--
	i.	학번 을입력 받을수 있게 만든다
 	   <input type="text" name="서블렛에서 입력한 학번을 꺼낼때 사용할 이름"/>
	
	 --%>
	 교수번호: <input type="text" name="profno"/><br/>
	  <%--
	i.	이름 을입력 받을수 있게 만든다
 	   <input type="text" name="서블렛에서 입력한 이름을 꺼낼때 사용할 이름"/>
	
	 --%>
	 이름: <input type="text" name="name"/><br/>
	  <%--
	i.	아이디 을입력 받을수 있게 만든다
 	   <input type="text" name="서블렛에서 입력한 아이디를 꺼낼때 사용할 이름"/>
	
	 --%>
	 아이디: <input type="text" name="userid"/><br/>
	  <%--
	i.	직급 을입력 받을수 있게 만든다
 	   <input type="text" name="서블렛에서 입력한 직급을 꺼낼때 사용할 이름"/>
	
	 --%>
	 직급: <input type="text" name="position"/><br/>
	  <%--
	i.	월급 을입력 받을수 있게 만든다
 	   <input type="text" name="서블렛에서 입력한 월급을 꺼낼때 사용할 이름"/>
	
	 --%>
	 월급: <input type="text" name="sal"/><br/>
	  <%--
	i.	성과급 을입력 받을수 있게 만든다
 	   <input type="text" name="서블렛에서 입력한 성과급을 꺼낼때 사용할 이름"/>
	
	 --%>
	 성과급: <input type="text" name="comm"/><br/>
	  <%--
	i.	입사일 을입력 받을수 있게 만든다
 	   <input type="text" name="서블렛에서 입력한 입사일을 꺼낼때 사용할 이름"/>
	
	 --%>
	 입사일: <input type="text" name="hiredate"/><br/>
	<%-- 
	학과 리스트 
	<select name="서블렛에서 선택한 학과번호를 리턴받을때 사용할 이름을 설정 ">
		<c:forEach items="${ProfessorService에서 설정한 전체 학과 리스트의 이름}"
		    var="전체 학과리스트에서 학과하나를 저장할 변수">
			<option value="${forEach태그에서 var 속성에서 설정한 변수명.deptno}">
			${forEach태그에서 var 속성에서 설정한 변수명.dname}
			</option>
		</c:forEach>
	</select>
	--%>
	학과: 
	<select name="deptno">
		<c:forEach items="${DEPT_LIST }" var="dept">
		<option value="${dept.deptno }">
			${dept.dname }
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