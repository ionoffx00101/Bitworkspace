import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OracleTesting")
public class OracleTesting extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public OracleTesting()
	{
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		try
		{
			// 1.드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공");

		} catch (ClassNotFoundException e)
		{
			System.out.println("드라이버 로딩 실패");
		}

		try
		{
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");
			System.out.println("커넥션 성공");

			// 실제 DB사용
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from emp");
			// select > executeQuery > return resultSet
			// insert update delete > executeUpdate() > return int rownum
			
			int insertrow = stmt.executeUpdate("INSERT INTO CRE_TAB1 VALUES (35,'five')");
			int updaterow = stmt.executeUpdate("update cre_tab1 set tab1_name='six' where tab1_num=35");
			int deleterow = stmt.executeUpdate("delete from cre_tab1 where tab1_num=35");
			
			PrintWriter out = response.getWriter();
			
			while (rs.next())
			{
			String ename=rs.getString("ename");
			String job=rs.getString("job");
			int empno = rs.getInt("empno");
			int deptno =rs.getInt("deptno");
			
			//out.println(empno+"	"+ename);
			//System.out.println(empno+""+ename);
				
			}
			if(insertrow>0){
				out.println("insert 됨");
			}
			
			// 커넥션 닫기 꼭
			conn.close();
			System.out.println("connection close");
		} catch (SQLException e)
		{
			System.out.println();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	}

}
