<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="code" value="89912" scope="request" />
<c:set var="name" value="Dduck" scope="request" />
<c:set var="price" value="15000" scope="request" />
<jsp:forward page="ProductInfoView.jsp" />
