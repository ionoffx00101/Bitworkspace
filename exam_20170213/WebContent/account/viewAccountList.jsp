<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>AccountService 실행 결과</p>
	<p>${ACCOUNT_LIST}</p>
	<p>1번 계좌 조회:${ACC}</p>
	<p>200만원 이상 계좌 조회:${BALANCE_LIST}</p>
	<p>200이상 500 이하 계좌:${BETWEEN}</p>
	
	<p><a href="AccountService?method=addAccountForm">계좌추가</a></p>
	<p><a href="AccountService?method=accountTransferForm">송금</a></p>
</body>
</html>

