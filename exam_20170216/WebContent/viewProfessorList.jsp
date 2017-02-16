<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	교수 여러명 조회하는 페이지 jstl 태그 위해서 상단에 태그립 넣고 for each문 구현 for each문으로 구현한 후에는 각 이름마다 한명으로 가는 링크 생성

	<table>
		<tr>
			<td>교수번호</td>
			<td>교수이름</td>
		</tr>
		<c:forEach items="${professorList}" var="professor">
			<tr>
				<td>${professor.profno}</td>
				<td><a href="viewProfessor?profno=${professor.profno}">${professor.name}</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>