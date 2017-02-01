<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="next" value="Divide.jsp">
	<c:param name="num1" value="999" />
	<c:param name="num2" value="1" />
</c:url>
<c:redirect url="${next}" />