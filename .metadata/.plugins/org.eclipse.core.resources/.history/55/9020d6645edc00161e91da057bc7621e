package kr.bit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BBSPostServlet
 */
@WebServlet("/bbs-post")
public class BBSPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BBSPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // euc-kr
		String name = request.getParameter("name");
		String title =request.getParameter("title");
		String content = request.getParameter("content");
		response.setContentType("text/html; charset=utf-8"); //euc-kr
		PrintWriter out = response.getWriter();
		out.println("<Html>");
		out.println("<head>");
		out.println("<title> 게시판 글쓰기 결과</title>");
		out.println("</head>");
		out.println("<body>");
		out.printf("이름 : %s<br>",name);
		out.printf("제목 : %s<br>",title);
		out.println("---------------------------------<br>");
		out.printf("<pre>%s</pre>",content);
		
		out.println("</body>");
		out.println("</html>");
		
	}

}
