<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 교수 조회</title>
</head>
<body>
 <%--전체 교수의 학번,이름을 출력   viewStudentList.jsp 참조--%>
 
  <table align="center" border="1">
  	<tr>
  		<td width="200">번호</td>
  		<td with="300">이름</td>
  	</tr>	
  <c:forEach  items="${professorList}" var="prof" varStatus="index">
    <tr>
    	<td>
    	 	${index.count}
    	 </td>	
    	<td>	
    		<a href="ProfessorService?method=viewProfessor&profno=${prof.profno}"> 
  	  		${prof.name}
  			</a>
  		</td>
  	</tr> 
 </c:forEach>
 </table>


</body>
</html>