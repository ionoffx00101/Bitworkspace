<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#color").change(function() {
			$.ajax({
				url : "/xml_20170206/BeerServiceArrayListToXML",
				type : "post",
				data:{color:$("#color").val()},
				success : function(result) {
					// xml로 파싱
					result=$.parseXML(result);
					
					$("#bname").empty();
					$("#brand").empty();
					$("#price").empty();
					$(result).find("beer").each(function(){
						$("#bname").append($(this).find("bname").text()+"	");
						$("#brand").append($(this).find("brand").text()+"	");
						$("#price").append($(this).find("price").text()+"	");
					});
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