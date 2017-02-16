<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
한 사람 보는 페이지 <br><br>
번호 : ${professor.profno}<br>
이름 : ${professor.name}<br>
월급 : ${professor.sal}<br>
성과급 : ${professor.comm}<br><br>
<a href="viewProfessorList">전체 교수 조회</a>
</body>
</html>