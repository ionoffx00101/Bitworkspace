<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form action="PetsResult.jsp">
ID : <input type="text" name="id"><br>
동물 선택 : 개<input type="checkbox" name="animal" value="개">
고양이 <input type="checkbox" name="animal" value="고양이">
사자<input type="checkbox" name="animal" value="사자"><br>
<input type="submit" value="submit">
<input type="reset" value="reset">

</form>
</body>
</html>