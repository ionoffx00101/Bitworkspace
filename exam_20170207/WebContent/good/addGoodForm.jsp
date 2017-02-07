<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
	<head> 
		<title>jQuery Mobile</title> 
		<meta charset="euc-kr" /> 	
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no"/>
		
		<link rel="shortcut icon" href="../image/icon.png">
		<link rel="apple-touch-icon" href="../image/icon.png"> 
		
		<link href="/exam_20170207/framework/jquery.mobile-1.0.css" rel="stylesheet" type="text/css" />
		<script src="/exam_20170207/framework/jquery-1.6.4.js"></script>
				
		
		
		<script src="/exam_20170207/framework/jquery.mobile-1.0.js"></script>

		
	</head>
	<body> 
      <div id="phonesaveform" data-role="page" data-theme="a">
	<div data-role="header" data-position="fixed" data-theme="a">
		<h1>폰 등록</h1>
		<a href="#" data-rel="back" data-icon="arrow-l">이전</a>
	</div>  
	
	<div data-role="content">
		<form method="post" enctype="multipart/form-data" data-ajax="false"
		 action="AddGoodService">
		 	
		 <div data-role = "fieldcontain">
			<label for="name">상품명 :</label><br><br>
			<input name="name" type="text">
		</div>
		<div data-role = "fieldcontain">
			<label for = "detail">상품설명 :</label><br><br>
			<input name="detail" type="text" >
		</div>
		 이미지 : <input type="file" name="file" value="업로드"/><BR><BR>
		 <div data-role = "fieldcontain">
			<label for = "price">가격 :</label><br><br>
			<input name="price" type="text" >
		</div>
		<input type = "submit" value="물건 등록"/>
	
		 
		 
		 </form>
	</div>	
</div>
</body>
</html>
