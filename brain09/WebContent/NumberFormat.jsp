<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
1 : <fmt:formatNumber value="1234500" groupingUsed="true"/><BR>
2 : <fmt:formatNumber value="3.141592" pattern="#.##"/><BR>
3 : <fmt:formatNumber value="10.5" pattern="#.00"/><BR>
</body>
</html>