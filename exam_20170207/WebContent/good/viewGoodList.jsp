<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<%
response.setHeader("cache-control","no-cache"); 
%>

<!DOCTYPE html> 
<html> 
	<head> 
		<title>전체 물건 조회</title> 
		<meta charset="UTF-8" /> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">
	
	
	<!--<link href="/exam_20170207/framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="/exam_20170207/framework/jquery-1.6.4.js"></script>
		<script src="/exam_20170207/framework/jquery.mobile-1.0.js"></script> -->
		
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
		<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
		<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
		
	</head>
	<body>
	<div id="phonelist" data-role="page" data-theme="a">
	<div data-role="header" data-position="fixed" data-theme="a">
		<h1>물건리스트</h1>
		<a href="#" data-icon="arrow-l" data-rel="back">이전</a>
		<a href="#" data-role="button" data-icon="arrow-r">다음</a>     
	</div> 
	
	<div data-role="content">
		<ul data-role="listview">
		<%--
			<c:forEach items="${GoodService의 viewGoodList에서 설정한 물건리스트의 이름}"
			   var="items 속성의 물건리스트에서 물건 하나를 꺼내서 저장할 변수">
			   <!--물건 하나 하나를 리스트로 출력 -->
			   <li>
			      <!--리스트에서 항목을 선택했을때 실행할 서블렛과 서블렛에 전송할 메시지 설정 : 물건 1개 조회-->
			   	  <a href="GoodService?method=viewGood&gnum=${forEach의 var 속성의 변수.gnum}">
			   	  	<!-- 물건 이미지 출력 -->
			   	  	<img src="/프로젝트명/photo/${forEach의 var 속성의 변수.img}"/>
			   	  	 <!-- 리스트에 출력할 메시지 출력 -->
			   	  	 ${forEach의 var 속성의 변수.name}
			   	  </a>
			   	</li>  	 
			</c:forEach>
			 --%>
		<c:forEach items="${GOOD_LIST}" var="good">
			   <!--물건 하나 하나를 리스트로 출력 -->
			   <li>
			      <!--리스트에서 항목을 선택했을때 실행할 서블렛과 서블렛에 전송할 메시지 설정 : 물건 1개 조회-->
			   	  <a href="GoodService?method=viewGood&gnum=${good.gnum}">
			   	  	<!-- 물건 이미지 출력 -->
			   	  	<img src="<c:url value="/photo/${good.img}"/>"/>
			   	  	 <!-- 리스트에 출력할 메시지 출력 -->
			   	  	 ${good.name}
			   	  </a>
			   	</li>  	 
			</c:forEach>
		</ul>
    </div>

	<div data-role="footer" data-position="fixed" data-theme="a">
	
	<div data-role="navbar">
		<ul>

			<li>
				<a href="GoodService?method=addGoodForm" data-icon="plus" rel="external">
				폰등록
				</a>
			</li>
		</ul>		
	</div>
	</div>
</div>
</body>
</html>