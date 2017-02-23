<!-- 물건 추가하는 페이지 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>물건 추가</title>
</head>
<body>
	<h2>추가할 물건 정보를 입력하시오</h2>
	<form action="/exam_20170223/addGood.do" method="post" enctype="multipart/form-data">
		물건이름 : <input type="text" name="name"/><br/>
		설명 : <input type="text" name="detail"/><br/>
		단가 : <input type="text" name="price"/><br/>
		이미지 : <input type="file" name="upImg"/><br/>
		<input type="submit" value="전송"/>
	</form>
</body>
</html>