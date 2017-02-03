<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!-- <script type="text/javascript" src="/xml_20170203/js/jquery.js"></script> -->
<script type="text/javascript">
	// $(document).ready(function(){}); 자바 스크립트 메인 문
	$(document).ready(function() {
		// id = # .=class 였나..그랬나?
		$("#color").change(function() {
			$("#recommend").empty(); // 해당 태그 자식 초기화 함수 올바르게 쓴건지 잘 모르겠음
			$.ajax({
				url : "/xml_20170203/BeerService",
				type : "post",
				data:{color:$("#color").val()}, //$(id속성값).val() 하면 입력값이나 선택값이 나온다
				success : function(result) {
					// $(id속성값).append(추가할것)
					$("#recommend").append(result);
				}
			});
		});
		/* 
		$.ajax({
			url : "/프로젝트명/서블릿명",
			type : "호출방식",
			data: 데이터(json > {"name속성값":"데이터"}),
			success : ajax요청을 완료했을 때 할 행동 function(리턴값을 받을 변수명) {}
		});
		 */
	});
</script>
</head>
<body>
		<select name="color" id="color">
			<option>red</option>
			<option>blue</option>
			<option>green</option>
		</select>
	<br>  맥주 추천 결과 : <span id="recommend"></span>
</body>
</html>