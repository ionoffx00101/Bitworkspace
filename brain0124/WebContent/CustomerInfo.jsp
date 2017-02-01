<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean class="brain0124.PersonalInfo" id="pinfo" />
<jsp:setProperty property="name" name="pinfo" value="david"/>
<jsp:setProperty property="gender" name="pinfo" value="F"/>
<jsp:setProperty property="age" name="pinfo" value="24"/>

이름 : <jsp:getProperty property="name" name="pinfo"/> 
성별 : <jsp:getProperty property="gender" name="pinfo"/>
나이 : <jsp:getProperty property="age" name="pinfo"/>
</body>
</html>