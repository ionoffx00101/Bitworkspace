<%@ page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		BufferedReader reader = null;
		try
		{
			String filePath = application.getRealPath("/WEB-INF/input.txt");
			System.out.println(filePath);
			reader = new BufferedReader(new FileReader(filePath));
			while (true)
			{
				String str = reader.readLine();
				if (str == null)
				{
					break;
				}
				out.println(str + "<br>");
			}
		} catch (FileNotFoundException e)
		{
			out.println("파일 존재 ㄴ");
		} catch (IOException e)
		{
			out.println("파일 읽 ㄴ");
		}
		finally{
			 try{
				 reader.close();
			 }
			 catch(Exception e){}
		 }
	%>
</body>
</html>