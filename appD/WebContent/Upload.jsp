<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" errorPage="UploadError.jsp"%>
<%@ page import="myutil.MultiPart" %>
<%@ page import="java.net.URLEncoder" %>
<%

request.setCharacterEncoding("UTF-8");

MultiPart multiPart = new MultiPart(request);

String title = multiPart.getParameter("title");
String description = multiPart.getParameter("description");


String fileName = multiPart.getFileName("upload_file");
//System.out.println("업로드"+fileName);
String newPath = application.getRealPath("/files/"+fileName);
//System.out.println("newPath"+newPath);

multiPart.saveFile("upload_file",newPath);

//String url = String.format("UploadResult.jsp?title=%s&description=%s&file_name=%s",title,description,fileName);

String url = "UploadResult.jsp?title="+title+"&description="+description+"&file_name="+URLEncoder.encode(fileName, "UTF-8");
//response.setContentType("text/html;charset=UTF-8");
response.sendRedirect(url);
%>