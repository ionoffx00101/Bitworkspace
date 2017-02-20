<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center" >
<img alt="" src="<c:url value="/photo/${good.img}"/>">
<p>${good.gnum}</p>
<p>${good.name}</p>
<p>${good.price}</p>
</div>
<form action="<c:url value="addCart.do"/>"  method="post">
<input type="hidden" name="gnum" value="${good.gnum}"/>
<input type="hidden" name="name" value="${good.name}"/>
<input type="hidden" name="price" value="${good.price}"/>
<input type="hidden" name="img" value="${good.img}"/>
<input type="text" name="qty"  value="1"/>개
<input type="submit" value="장바구니담기"/>
</form>
<a href="<c:url value="viewGoodList.do"/>">물건 전체 목록</a>
</body>
</html>