<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
             
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="pinfo" class="brain0124.BookInfo" scope="request"/>
<jsp:setProperty name="pinfo" property="code" value="50001" />    
<jsp:setProperty name="pinfo" property="name" value="DDuk" />
<jsp:setProperty name="pinfo" property="price" value="52403" />
<jsp:setProperty name="pinfo" property="writer" value="Grasom" />
<jsp:setProperty name="pinfo" property="page" value="2000" />

책 정보 저장 <br>
---------------------- <br>
<jsp:include page="ProductInfo.jsp" />
</body>
</html>