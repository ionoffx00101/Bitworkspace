<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {

		alert("First READY");
		$('h1').css("color", "red");

		alert("아이디 속성 target 오랜지로 바꾸기");
		$("#target").css("color", "orange");

	});
</script>
<title>Insert title here</title>
</head>
<body>
	<h1>h1h1</h1>
	<p>p1p1</p>
	<h1 id="idh1">idh1--2-30---</h1>
	<p>--------p------------p---------p----------p--p-</p>
	<input id="chred" type="button" value="to the red">
	<input id="chblack" type="button" value="to the black">
</body>
</html>