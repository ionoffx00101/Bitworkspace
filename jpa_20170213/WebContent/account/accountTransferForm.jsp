<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>송금</title>
</head>
<body>
	<form action="AccountService"  method="post">
		<p>돈보내는사람 계좌번호<input type="text"  name="snum" value="1"/></p>
		<p>돈 받는 사람 계좌번호<input type="text"  name="rnum" value="2"/></p>
		<p>보낼금액<input type="text"  name="money"  value="1000"/></p>
		<p><input type="submit"  value="송금"/></p>
		<input type="hidden"  name="method"  value="accountTransfer"/>
	</form>
</body>
</html>