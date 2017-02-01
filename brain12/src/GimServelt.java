import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GimServelt
 */
@WebServlet("/gimlist")
public class GimServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GimServelt() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//DB 연결
		Connection conn = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.17:1521:xe", "scott", "tiger");

			//실제 DB사용
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("Select * from goodsinfo");

			GIMInfo goodsinfo = new GIMInfo();
			while (rs.next()) {

				String code = rs.getString("code");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				int price = rs.getInt("price");
				/*request.setAttribute("code", code);
				request.setAttribute("title", title);
				request.setAttribute("writer", writer);
				request.setAttribute("price", price);*/
				goodsinfo.setCode(code);
				goodsinfo.setTitle(title);
				goodsinfo.setWriter(writer);
				goodsinfo.setPrice(price);
			}
			request.setAttribute("goodinfo", goodsinfo);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("sql오류");
		} finally{// 무조건 실행 하는 영역
			try {
				// stmt 꺼주기
				stmt.close();
			} catch (Exception e) {
			}
			try {
				// conn 꺼주기
				conn.close();
			} catch (Exception e) {
			}
		}
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/GIM/list.jsp");
		//dispatcher.forward(request, response);\
		// 맘에 들진 않지만 페이지 연결은 시킴.. 흠..
		String link="/brain12/GIM/list.jsp"; 
		response.sendRedirect(link);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
