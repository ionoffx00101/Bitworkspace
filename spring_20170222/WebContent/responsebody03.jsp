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
				url : "<c:url value="carlist.do"/>",
				type : "post",
				dataType : "json",/* json */
				success : function(result) {

					alert(JSON.stringify(result));
					for (var i = 0; i < result.length; i++) {
						var obj = result[i];
						alert(obj.name + " & " + obj.brand);
					}
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