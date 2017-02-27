<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.min.js"></script>
<script type="text/javascript">
	$(document).ready(

	function() {
		
		$("#sendBtn").attr("disabled", "true");
		
	});
</script>
</head>
<body>
	<textarea rows="15" cols="21"></textarea>
	<br>
	<input type="text" name="chatBox" id="chatBox">
	<input type="button" id="sendBtn" value=" 전송 ">
	<br>
</body>
</html>