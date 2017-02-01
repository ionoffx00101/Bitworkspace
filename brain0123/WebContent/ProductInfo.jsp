<%@page import="mall.ProductInfo"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
ProductInfo product = new ProductInfo();
product.setName("초코라바케이쿠");
product.setPrice(20000);
request.setAttribute("product", product);
RequestDispatcher dispatcher = request.getRequestDispatcher("ProductInfoView.jsp");
dispatcher.forward(request, response);
%>