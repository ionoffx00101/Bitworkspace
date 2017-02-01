<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%
	// 파라미터로 넘어오는 값 확인
	String code = request.getParameter("code");
	if (code == null)
	{
		throw new Exception("상품 코드를 입력하세요");
	}

	//DB 연결
	Connection conn = null;
	Statement stmt = null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");
		if (conn == null)
		{
			throw new Exception("데이터 베이스에 연결할 수 없습니다.");
		}
		//실제 DB사용
		stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from goodsinfo where code ='" + code + "'");
		if (!rs.next())
		{//rs.next가 반환하는 값이 false면
			throw new Exception(code + "에 해당하는 데이터가 없습니다");
		}

		//DB에서 받아온 한줄의 값 확인 하기(여러행의 값이면 반복문으로 rs을 돌려가며 값을 보여줘야함)
		String title = rs.getString("title");
		String writer = rs.getString("writer");
		int price = rs.getInt("price");

		//request객체에 DB에서 받아온 값을 넣어주기
		request.setAttribute("code", code);
		request.setAttribute("title", title);
		request.setAttribute("writer", writer);
		request.setAttribute("price", price);

	} finally
	// 무조건 실행 하는 영역
	{
		try
		{
			// stmt 꺼주기
			stmt.close();
		} catch (Exception e)
		{

		}
		try
		{
			// conn 꺼주기
			conn.close();
		} catch (Exception e)
		{

		}
	}
	// DB연결해서 얻을 데이터 다 얻었으니 데이터 보여줄 페이지로 연결 시켜주기
	RequestDispatcher dispatcher = request.getRequestDispatcher("EditForm.jsp");
	dispatcher.forward(request, response);
%>