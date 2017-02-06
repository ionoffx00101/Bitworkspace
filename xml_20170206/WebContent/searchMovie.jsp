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
		$("#search").click(function() {
			$.ajax({
				url : "<c:url value="/MovieService"/>",
				type : "post",
				data : {
					query : $("#query").val()
				},
				success : function(result) {

					// xml로 파싱
					result = $.parseXML(result);
					
					//기존 데이터 지워주기
					$("#movieResult").empty();
					// 큰 묶음부터 찾기
					$(result).find("item").each(function() {
						// var 변수명 = $(큰묶음 가르키는 this).find("세부적으로 찾을 변수").text();
						var title = $(this).find("title").text();
						var link = $(this).find("link").text();
						var image = $(this).find("image").text();
						$("#movieResult").append("<p><img src='"+image+"'><a href='"+link+"'>"+" 제목:"+title+"</a>"+"</p>");
					});
				}
			});
		});
	});
</script>
</head>
<body>
	<input type="text" id="query" name="query">
	<input type="button" id="search" value="moviesearch">
	<span id="movieResult"></span>
</body>
</html>