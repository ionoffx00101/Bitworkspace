<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="pinfo" class="brain0124.ProductInfo" scope="request"/>
�ڵ� : <jsp:getProperty property="code" name="pinfo"/>
��ǰ�� : <jsp:getProperty property="name" name="pinfo"/>
���� : <jsp:getProperty property="price" name="pinfo"/>