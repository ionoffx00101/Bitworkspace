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
<br/>
 	<a href="ProfessorService?method=addProfessorForm">교수 추가</a>
 <br/> 
<%--전체 교수의 학번,이름을 출력   viewStudentList.jsp 참조--%>
 <%--
  <table align="center" border="1">
  	<tr>
  		<td width="200">번호</td>
  		<td with="300">이름</td>
  	</tr>
  	--%>
	<table align="center" border="1">
		<tr>
			<td width="200">번호</td>
			<td width="300">이름</td>
		</tr>
<%--		
  <c:forEach  items="${ProfessorService의 viewProfessorList메서드에서 설정한 전체 교수 리스트의 JSP에서 사용할 이름}"
     var="전체 교수 정보에서 교수한명을 꺼내서 저장할 변수의 이름 "
     varStatus="index">
    <tr>
    	<td>
    	 	${index.count}
    	 </td>	
    	<td>	
    		<a href="ProfessorService?method=viewProfessor&profno=${forEach태그의 var에서 설정한 변수명.profno}"> 
  	  		${forEach태그의 var 속성에서 설정한 변수이름.name}
  			</a>
  		</td>
  	</tr> 
 </c:forEach>
 </table>
  --%>		
		<c:forEach items="${PROFESSOR_LIST}"   var="PROFESSOR"  varStatus="index">
			<tr>
				<td>
					${index.count}
				</td>
				<td>
					<a href="ProfessorService?method=viewProfessor&profno=${PROFESSOR.profno}">
					${PROFESSOR.name}
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	

</body>
</html>