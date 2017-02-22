<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#callCar").click(function() {
			$.ajax({
				url : "<c:url value="car.do"/>",
				type : "post",
				dataType : "text",/* json */
				success : function(result) {
					// 온 데이터가 xml이니까 parseXML써줘야함
					// var 안써도 되나봐
					var parsexml = $.parseXML(result);

					// 해석된 xml을 이용해서 원하는 데이터를 찾기 시작함
					// 젤 큰 단위를 찾는다.
					// .each가 큰 단위부터 반복해가면서 작은 단위를 찾아준다.
					$(parsexml).find("car").each(function() {
						// $(this)가 가르키는건 말 안해도 알것이다. 사실 설명을 못 하겠다. 알긴 알겠는데 흠..
						var name = $(this).find("name").text();
						var brand = $(this).find("brand").text();
						alert(name+" & "+brand);
					})
				}
			});
		});
	});
</script>
<title>ajax랑 responsebody랑 함께 하는 세상</title>
</head>
<body>
	<input type="button" value="Button" id="callCar" />

</body>
</html>