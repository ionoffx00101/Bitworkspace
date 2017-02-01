<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.sql.PreparedStatement"%>
<%
	// post로 넘어오는 값 빼오기
	request.setCharacterEncoding("utf-8");
	String code = request.getParameter("code");
	String title = request.getParameter("title");
	String writer = request.getParameter("writer");
	String price = request.getParameter("price");
	if (code == null || title == null || writer == null || price == null) {
		throw new Exception("누락된 데이터가 있습니다");
	}

	//DB 연결
	Connection conn = null;
	//Statement stmt = null;
	PreparedStatement pstmt = null;
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");
		if (conn == null) {
			throw new Exception("데이터 베이스에 연결할 수 없습니다.");
		}

		//실제 DB사용
		//stmt = conn.createStatement();
		//sql 문 만들어주기
		//String command = String.format("update goodsinfo set title :='%s',writer :='%s',price :='%s' where code = '%s'",title,writer,price,code);
		// oracle은 :=을 인식하지 못하는것 같아서 그냥 통으로 입력해줬더니 된다.. 흠.. 이게 좋은 방법인가..?
		//int rownum = stmt.executeUpdate("update goodsinfo set title ='"+title+"',writer ='"+writer+"',price ="+price+" where code ='"+code+"'");

		pstmt = conn.prepareStatement("update goodsinfo set title =?,writer =?,price =? where code =?");
		pstmt.setString(1, title);
		pstmt.setString(2, writer);
		pstmt.setString(3, price);
		pstmt.setString(4, code);
		int rownum = pstmt.executeUpdate();
		
		if (rownum < 1)//rownum이 0이라면
		{
			throw new Exception("DB에 입력할 수 없습니다");
		}

	} finally
	// 무조건 실행 하는 영역
	{
		try {
			// stmt 꺼주기
			//stmt.close();
			// pstmt 꺼주기
			pstmt.close();
		} catch (Exception e) {
		}
		try {
			// conn 꺼주기
			conn.close();
		} catch (Exception e) {

		}
	}
	// DB연결해서 얻을 데이터 다 얻었으니 데이터 보여줄 페이지로 연결 시켜주기
	response.sendRedirect("UpdateResult.jsp?code=" + code);
%>