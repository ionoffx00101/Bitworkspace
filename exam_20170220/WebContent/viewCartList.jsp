<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table align="center">
		<tr>
			<td></td>
			<td>번호</td>
			<td>물건이름</td>
			<td>개수</td>
			<td>가격</td>
			<td>해당 물건 개격</td>
		</tr>
		<c:forEach items="${goodList}" var="good">
			<td>
				<img alt="" src="<c:url value="/photo/${good.img}"/>">
			</td>
			<td>${good.gnum}</td>
			<td>${good.name}</td>
			<td>${good.price}</td>
			<td>${good.qty}</td>
			<td>${good.price*good.qty}</td>

		</c:forEach>

	</table>
			<p align="center"><a href="<c:url value="viewGoodList"/>">쇼핑하기</a></p>
</body>
</html>