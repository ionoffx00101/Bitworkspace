<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>물건 정보</title>
</head>
<body>
	<%--
	GoodService의 viewGood() 에서 전송한 물건 정보에서 물건번호,물건명, 단가, 이미지를 EL을 이용해서 출력
	이미지는 <img src="/프로젝트명/photo/물건의이미지EL"/> 로 출력 
	
	 --%>
	<h3 align="center">물건 정보</h3>
	<table align="center">
	<tr>
		<td rowspan="4">
		<img src="/exam_20170223/photo/${ GOOD.img }"/>
		</td>
		<td width="200">물건번호</td>
		<td>${ GOOD.gnum }</td>
	</tr>
	<tr>
		<td>물건명</td>
		<td>${ GOOD.name }</td>
	</tr>
	<tr>
		<td>단가</td>
		<td>${ GOOD.price }</td>
	</tr>
	<tr>
		<td>설명</td>
		<td>${GOOD.detail}</td>
	</tr>				
	</table>
	<br/>
	<br/>
	<form action="/exam_20170223/addCart.do"
	  method="post" ><!-- align="center" -->
		<input type="hidden" name="gnum" value="${ GOOD.gnum }" />
		<input type="hidden" name="name" value="${ GOOD.name }" />
		<input type="hidden" name="price" value="${ GOOD.price }" />
		<input type="hidden" name="img" value="${ GOOD.img }" />
		<input type="text" name="qty" value="1" />개
		<input type="submit" value="장바구니담기" />
	</form>
	<!-- </table> -->
</body>
</html>