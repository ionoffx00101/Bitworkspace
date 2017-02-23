<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 상품 정보 출력</title>
</head>
<body>
<%--
GoodService의 viewGoodList() 메서드에서 전송한 
전체 물건의 물건번호, 물건명  정보를 JSTL을 이용해서 출력

 --%><div align="center"><a href="<c:url value="addCustomerForm.do"/>">회원추가</a> </div>
	<h3 align="center">전체 상품 정보</h3>
	<table align="center"  border="3">
		<tr>
			<th width="200">물건번호</th>
			<th width="200">이미지</th>
			<th width="200">물건명</th>
			<th width="200">가격</th>
		</tr>
	<%--
	STL의 <c:forEach ..> 를 이용해서 ProfessorService의 viewProfessorList의 3에서
	전송한 교수 리스트의 교수번호, 교수 이름을 출력
	 --%>		
	<c:forEach items="${GOOD_LIST}" var="good">
		<tr>
			<td align="center">
				<a href="<c:url value="viewGood.do?gnum=${good.gnum}"/>">${good.gnum}</a>
			</td>
			<td align="center">
			<img src="/exam_20170223_1/photo/${good.img}"/>
			</td>
			<td align="center">
				
				${good.name}
			</td>
			<td align="center">
				${good.price}
			</td>	
		</tr>		
	</c:forEach>
	</table>
	<br/>
	<a href="<c:url value="addGoodForm.do"/>">물건 추가</a>
</body>
</html>