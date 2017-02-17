<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>영화 입력</title>
</head>
<body>
	영화입력
	<br>
	<br>
	<form action="<c:url value="addMovie"/>" method="post">
	번호 : <input type="text" name="movienum" value="54"/><br/>
	이름 : <input type="text" name="name" value="aaa"/><br/>
	배우 : <input type="text" name="actorname" value="das"/><br/>
	개봉일 : <input type="text" name="odate" value="2017-02-17"/><br/>
	<input type="submit" value="추가"/>
	</form>
</body>
</html>