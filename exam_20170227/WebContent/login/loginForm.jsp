<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
</script>
</head>
<body>
<div align="center">
	여기는 로그인 폼<br>
	아이디와 비밀번호를 넣는 곳이죠<br><br>
	<p><c:if test="${ERROR!=null}">${ERROR}<br></c:if></p>
	<form action="login.do" method="post">
	
	ID : <input type="text" name="id"><br>
	PW : <input type="password" name="pw"><br><br>
	<input type="submit" name="submit"> <input type="reset" name="reset">
	</form>
	</div>
</body>
</html>