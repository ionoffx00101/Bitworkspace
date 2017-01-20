<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 이름 : <%=request.getParameter("SongName") %>.txt</h2>
	<%
		BufferedReader reader = null;
		try {
			String filePath = application.getRealPath("/WEB-INF/songs/"+request.getParameter("SongName")+".txt");
			reader = new BufferedReader(new FileReader(filePath));
			while(true) {
				String str = reader.readLine();
				if(str==null) break;
				out.println(str + "<br/>");
			}
		} catch(Exception e) { out.println("에러."); 
		} finally {
			try {
				reader.close();
			} catch(Exception e) { }
		}
	%>
</body>
</html>