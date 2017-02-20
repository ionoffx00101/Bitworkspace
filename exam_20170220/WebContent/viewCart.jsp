<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<c:url value="addCart"/>"  method="post">
<input type="hidden" name="gnum" value="물건번호 출력 EL"/>
<input type="hidden" name="name" value="물건이름 출력 EL"/>
<input type="hidden" name="price" value="물건단가 출력 EL"/>
<input type="hidden" name="img" value="물건이미지파일명 출력 EL"/>
<input type="text" name="qty"  value="1"/>개
<input type="submit" value="장바구니담기"/>
</form>

</body>
</html>