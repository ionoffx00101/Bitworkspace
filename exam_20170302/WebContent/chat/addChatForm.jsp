<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>채팅방 참여</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.2/sockjs.min.js"></script>

<script type="text/javascript">
	$(function() {
		var userListSock = new SockJS(
				"http://localhost:8085/exam_20170302/loginUserList.do");
		userListSock.onopen = function() {
			userListSock.send("Anybody Out there?"); // 저쪽에서 start를 받을때에는 내가 start라는 말을 보내야겠지.
			//userListSock.send('start','${LOGIN_USER.id}');
		};
		userListSock.onmessage = function(data) {

			//$(“#로그인중인 사용자 리스트가 출력되는 textarea아이디”).text(“”);
			// 1. 서버에서 보낸 데이터를 변수에 저장
			//  2. 1의 변수를 JSON 객체로 변환해서 변수json에 저장
			//var json = jQuery.parseJSON(1의 변수 );
			// 3. json.list 에 저장된 객체의 수 ( length 속성) 를 변수 size에 저장
			// 4. json.list에 저장된 i번째 객체를 꺼내서 변수 user에 저장
			// 6. user.nickname을 변수에 저장
			// 7.  $(“#로그인중인 사용자 리스트가 출력되는 textarea아이디”).append(6변수+”\n”);
			$('#loginUserList').text('');
			// ? 저위에 functioon매개변수 아닙니까
			var json = jQuery.parseJSON(data); // $.parseJSOON(data.data)
			// 34567
			for (var i = 0; i < json.list.length; i++) {
				var user = json.list[i]; // 이게 맞나
				$('#loginUserList').append(user.nickname+'\n');
			}

		}

		// 기존 chatmsg 영역  
		var sock = new SockJS("http://localhost:8085/exam_20170302/chatmsg.do");
		sock.onopen = function() {
			$('#sendMsg').prop('disabled', false);
			sock.send('start,' + '${sessionScope.LOGIN_USER.id}');
		};
		sock.onmessage = function(message) {
			//alert(message.data);
			var xmlDoc = $.parseXML(message.data);
			var $xml = $(xmlDoc);

			var $chatmsgList = $xml.find('chatmsg');
			$chatmsgList.each(function(index) {
				var $chatmsg = $(this);
				var nickname = $chatmsg.find('user').find('nickname').text();
				var oldMsg = $('#msgArea').text();
				var newMsg = $chatmsg.find('msg').text();
				$('#msgArea').text(nickname + ': ' + newMsg + '\n' + oldMsg);
			});
		};
		sock.onclose = function(event) {
			$('#fromServerMsg').append('<p>서버 종료!!</p>');
			$('#disconnect').prop('disabled', true);
		};

		function messageSend() {
			$('#sendMsg').on('click', function() {
				var $inputMsg = $('#inputMsg');
				sock.send('msg,' + $inputMsg.val());
			});
		}

		$(window).on('beforeunload', function() {
			sock.send('end');
			sock.close();
		});

		messageSend();
	});
</script>
</head>
<body>
	<%--i.	채팅 메시지를 입력받고 누룰수 있는 버튼과 입력 상자를 작성 --%>
	<textarea rows="20" cols="50" id="loginUserList"></textarea>
	<p>
		메시지
		<input type="text" id="inputMsg" />
		<%--iii.	i의 버튼은 비활성화되서 클릭할수 없도록 한다 --%>
		<input type="button" id="sendMsg" disabled="disabled" value="전송" />
	</p>
	<p>서버가 보낸 메시지</p>
	<p>
		<%--ii.	서버에서 전송한 메시지는 화면아래 <textarea> 에 출력되도록 한다
		1.	textarea 의 가로는 cols="가로길이"  세로는 rows="세로길이" 이다
		2.	눈으로 보고 적절한 크기로 textarea 객체의 크기를 설정한다
   --%>
		<textarea cols="100" rows="20" id="msgArea"></textarea>
	</p>
</body>
</html>