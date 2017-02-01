<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>상품 정보 수정</title>
</head>
<body>
	상품 코드 수정 하고 수정 버튼 눌러요
	<form action="Updater.jsp" method="post">
		코드 : <input type="text" name="code" size="5" value='${code}' readonly="readonly"><br>
		제목 : <input type="text" name="title" size="5" value='${title}' ><br>
		저자 : <input type="text" name="writer" size="5" value='${writer}' ><br>
		가격 : <input type="text" name="price" size="5" value='${price}' >원<br>
		<input type="submit" value="modify">
	</form>
</body>
</html>