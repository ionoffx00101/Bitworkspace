<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>계좌추가</title>
</head>
<body>
	<form action="AccountService"  method="post">
		<p>계좌번호:<input type="text"  name="num"/></p>
		<p>계좌주인<input type="text"  name="owner"/></p>
		<p><input type="submit"  value="계좌만들기"/></p>
		<p><input type="hidden" name="method"  value="addAccount"/></p>
	</form>
</body>
</html>