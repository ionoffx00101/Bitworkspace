<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="pinfo" class="brain0124.PersonalInfo"/>
<jsp:setProperty property="*" name="pinfo"/>
name : <jsp:getProperty property="name" name="pinfo"/><br>
gender : <jsp:getProperty property="gender" name="pinfo"/><br>
age : <jsp:getProperty property="age" name="pinfo"/><br>
</body>
</html>