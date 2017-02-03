<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BeerService" method="post">
		<select name="color">
			<option>red</option>
			<option>blue</option>
			<option>green</option>
		</select>
		<input type="submit" value="submit">
	</form>
	<br> 맥주 추천 결과 : ${result}
</body>
</html>