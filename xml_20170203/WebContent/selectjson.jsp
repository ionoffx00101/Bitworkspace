<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="/xml_20170203/js/jquery.js"></script> -->
<script type="text/javascript">

	$(document).ready(function() {
	
		$("#color").change(function() {
			$.ajax({
				url : "/xml_20170203/BeerServiceJSON",
				type : "post",
				dataType:"json",
				data:{'color':$('#color').val()}, //$(id속성값).val() 하면 입력값이나 선택값이 나온다
				success : function(result) {
					//code assist
					$("#bname").append(result);
				}
			});
		});
	});
</script>
</head>
<body>
	<select name="color" id="color">
		<option>red</option>
		<option>blue</option>
		<option>green</option>
	</select><br>
	<h1>맥주 추천 결과</h1><br>
	맥주 이름 : <span id="bname"></span><br>
	맥주 브랜드 : <span id="brand"></span><br>
	맥주 가격 : <span id="price"></span><br>
</body>
</html>