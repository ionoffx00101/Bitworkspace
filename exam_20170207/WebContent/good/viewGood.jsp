<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
<%
response.setHeader("cache-control","no-cache"); 
%>

<!DOCTYPE html> 
<html> 
	<head> 
		<title>물건 상세 정보</title> 
		<meta charset="UTF-8" /> 	
		<meta name="viewport" 
				content="width=device-width, initial-scale=1.0, 
							maximum-scale=1.0, minimum-scale=1.0, 
							user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png">
	
	
		
<!-- 		<link href="/exam_20170207/framework/jquery.mobile-1.0.css" 
			rel="stylesheet" type="text/css" />
		<script src="/exam_20170207/framework/jquery-1.6.4.js"></script>
		<script src="/exam_20170207/framework/jquery.mobile-1.0.js"></script> -->
		
		<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css" />
<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>

	</head>
	<body> 
	<div id="phonedetail" data-role="page" data-theme="a">
	<div data-role="header" data-theme="a">
		<h1>물건상세 내용</h1>
	</div>  

	<div data-role="content">
		<ul data-role="listview">
			<li>
				<table>
					<tr>
						<td style="padding-right: 5px">
						<%--
							2. 물건의 이미지 출력
							물건이미지는
							<img src="/프로젝트명/photo/${GoodService의 viewGood에서 설정한 Good 객체의 이름.img}"/> 으로 출력한다
							 --%>
						<img src="<c:url value="/photo/${good.img}"/>"/>	
						</td>
						<td style="padding-left: 5px">
							<table>
								<tr style="padding: 5px">
									<td style="padding: 5px">물건정보 : </td>
									<td>
									
									<%--
									${GoodService의 viewGood에서 설정한 Good 객체의 이름.detail}
									 --%>
									${good.detail}
									</td>
								</tr>
								
								<tr style="padding: 5px">
									<td style="padding: 5px">상품가 : </td>
									<td>
									<%--
									${GoodService의 viewGood에서 설정한 Good 객체의 이름.price}
									 --%>
									${good.price}
									</td>
								</tr>

							</table>
						</td>
					</tr>
				</table>
			</li>
		</ul>
    </div>
    
	<div data-role="footer" data-position="fixed" data-theme="a">
	<div data-role="navbar">
	
	<ul>
		
			<li>
			<a href="GoodService?method=viewGoodList" data-icon="grid">
			목록
			</a>
		</li>
		<li>
			<a href="#" data-icon="grid">
			장바구니
			</a>
		</li>
	</ul>
	</div>	
    </div>
</div>
</body>
</html>