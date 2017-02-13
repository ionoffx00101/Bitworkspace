<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
	<p>AccountService 실행 결과</p>
	<br>
	<br>
	<input type="text" value="search">
	<button type="submit">검색</button>
	<br>
	<table>
		<c:forEach items="${ACCOUNT_LIST}" var="account">
			<tr>
				<td>${account.num}</td>
				<td>
					<a href="AccountService?method=viewAccount&accountnum=${account.num}">${account.owner.ownername}</a>
				</td>
				<td>${account.balance}</td>
			</tr>
		</c:forEach>

	</table>
	<p></p>
	<p>
		<a href="AccountService?method=addAccountForm">계좌추가</a>
	</p>
	<p>
		<a href="AccountService?method=accountTransferForm">송금</a>
	</p>
</body>
</html>