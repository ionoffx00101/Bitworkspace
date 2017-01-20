<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>노래 파일 목록</h2>
	<%
		File file = null;
		try {
			file = new File(
						application.getRealPath("/WEB-INF/songs")
					);
		} catch(Exception e) { e.printStackTrace(); }
		
		String[] arrStr = file.list();
		for(int i=0; i<arrStr.length; i++) {
			out.println("<a href='SongReader.jsp?SongName="+arrStr[i].substring(0,arrStr[i].length()-4)+"'>"+arrStr[i]+"</a><br/>");
		}
	%>
<!-- 
	<a href="SongReader.jsp?SongName=airplane">airplane.txt</a><br/>
	<a href="SongReader.jsp?SongName=puppy">puppy.txt</a><br/>
	<a href="SongReader.jsp?SongName=school">school.txt</a>
-->
</body>
</html>