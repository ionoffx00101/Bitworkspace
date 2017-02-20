<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<c:url value="viewGoodList.do"/>" >쇼핑하기</a>
	<table align="center" >
		<tr>
			<td>사진사진</td>
			<td>번호</td>
			<td>물건이름</td>
			<td>개수</td>
			<td>가격</td>
			<td>해당 물건 가격</td>
		</tr>
		<c:forEach items="${cartList}" var="cart">
			<tr>
				<td>
					<img alt="" src="<c:url value="/photo/${cart.img}"/>">
				</td>
				<td>${cart.gnum}</td>
				<td><a href="<c:url value="viewGood.do?gnum=${cart.gnum}"/>">${cart.name}</a></td>
				<td>${cart.price}</td>
				<td>${cart.qty}</td>
				<td>${cart.price*cart.qty}</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>