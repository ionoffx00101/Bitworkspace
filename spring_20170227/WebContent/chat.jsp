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
	var sock = new SockJS("http://localhost:8085/spring_20170227/chat.do");
	$(document).ready(

	function() {
		alert("jquery준비 완료!");
		$("#sendbtn").attr("disabled", "true");
		sock.onopen = function() {
			$("#fromservermsg").append("<p>socket ready</p>")
			$("#sendbtn").removeAttr("disabled");
			sock.send("start");
		}

		$("#sendbtn").click(function() {
			alert("서버로 메시지 전송");
			sock.send($("#inputmsg").val());
		});

		sock.onmessage = function(e) {
			$("#fromservermsg").append("<p>server message:" + e.data + "</p>");
		}
	});
	$(window).bind("beforeunload", function() {
		alert("윈도우 종료");
		sock.send("end");
		sock.close();
	});
</script>
</head>
<body>
<p>
		메세지 <input type="text" id="inputmsg" /> <input type="button"
			id="sendbtn" value="메시지 전송" />
	</p>
	<p>서버가 보낸 메시지</p>
	<p>
		<span id="fromservermsg"></span>
	</p>
</body>
</html>