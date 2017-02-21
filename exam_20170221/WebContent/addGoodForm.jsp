<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>물건 추가 페이지</title>
</head>
<body>
<div align="center">
<br/>
<h3>물건 추가하는 곳</h3><br/>
<form action="<c:url value="addGood.do"/>" method="post" enctype="multipart/form-data" >
이름 : <input type="text" name="name" value="namenamename"/><br/>
단가 : <input type="text" name="price" value="520324"/><br/>
설명 : <input type="text" name="detail" value="detailtailtail"/><br/>
이미지파일 : <input type="file" name="uploadFile"/><br/>
<br/>
<input type="submit" name="upload">
</form>
<br/>
<a href="<c:url value="viewGoodList.do"/>" >쇼핑하기</a>
<a href="<c:url value="viewCartList.do"/>" >장바구니</a>
</div>
</body>
</html>