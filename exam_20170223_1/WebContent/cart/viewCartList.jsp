<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>전체 장바구니 정보 출력</title>
</head>
<body>
	<%--
	CartService에서 전송한 장바구니 리스트인 
	ArrayList<Good> 타입의 객체를 꺼내서 JSTL을 이용해서
	물건번호,물건명, 개수,단가, 개수*단가 물건이미지 를 출력한다

	개수*단가는 ${Good객체명.개수속성*Good객체명.단가속성}
	이미지는 <img src="/프로젝트명/photo/물건의이미지EL"/> 로 출력

	화면아래에
	<a href="/프로젝트명/viewGoodList.do">쇼핑하기</a>
	 --%>
	<h3 align="center">전체 장바구니 정보</h3>
	<table align="center"  border="1">
		<tr>
			<th width="200">물건번호</th>
			<th width="200">물건이미지</th>
			<th width="200">물건명</th>
			<th width="200">개수</th>
			<th width="200">단가</th>
			<th width="200">개수 * 단가</th>
			
		</tr>
	<%--
	STL의 <c:forEach ..> 를 이용해서 ProfessorService의 viewProfessorList의 3에서
	전송한 교수 리스트의 교수번호, 교수 이름을 출력
	 --%>		
	<c:forEach items="${CART_LIST}" var="cart">
		<tr>
			<td>
				<a href="/exam_20170223_1/viewGood.do?gnum=${cart.gnum}">${cart.gnum}</a>
			</td>
			<td>
				<img src="/exam_20170223_1/photo/${cart.img}"/>
			</td>
			<td>
				${cart.name}
			</td>
			<td>
				${cart.qty}
				<form action="/exam_20170223_1/removeCart.do" method="post">
					<input type="hidden" name="gnum" value="${ cart.gnum }"/>
					<input type="submit" value="장바구니 삭제"/>
				</form>
			</td>
			<td>
				${cart.price}
			</td>
			<td>
				${cart.qty * cart.price}
			</td>
			
		</tr>		
	</c:forEach>
	</table>
	<p align="center"><a href="/exam_20170223_1/viewGoodList.do">쇼핑하기</a></p>
	
</body>
</html>