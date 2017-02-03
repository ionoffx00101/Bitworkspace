
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BeerService
 */
@WebServlet("/BeerService")
public class BeerService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeerService() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 첫 실행되는 영역 , 실행되고 바로 select.jsp로 넘겨줌
		// 이동할 주소를 만들어 주었다
		RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");
		// 만든 주소로 이동하자
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dopost로 온 값을 처리함
		// 한글인코딩이라고 알려줌
		request.setCharacterEncoding("UTF-8"); 
		// 받아온 값을 color변수에 넣어줌
		String color = request.getParameter("color"); 
		String result = null;

		// jsp에서 온값을 받아서 맥주추천을 하는 알고리즘을 짬
		if ("red".equals(color)) {
			result = "코로나";
		} else if ("blue".equals(color)) {
			result = "스텔라";
		} else {
			result = "하이네켄";
		}

		// jsp로 추천 맥주 값을 보내줌
		// request에 result값을 넣어줌
		request.setAttribute("result", result); 

		// 이동할 주소를 만들어 주었다
		RequestDispatcher dispatcher = request.getRequestDispatcher("select.jsp");
		// 만든 주소로 이동하자
		dispatcher.forward(request, response);
	}

}
