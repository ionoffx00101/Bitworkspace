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
@WebServlet("/BeerServiceJSON")
public class BeerServiceJSON extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeerServiceJSON() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 첫 실행되는 영역 , 실행되고 바로 select.jsp로 넘겨줌
		// 이동할 주소를 만들어 주었다
		RequestDispatcher dispatcher = request.getRequestDispatcher("selectxml.jsp");
		// 만든 주소로 이동하자
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 받아온 값 한글화
		request.setCharacterEncoding("UTF-8");
		// 받아온 값을 color변수에 넣어줌
		String color = request.getParameter("color");

		System.out.println("응옴"+color);
		// JSON 코딩
		String result = "";

		// jsp에서 온값을 받아서 맥주추천을 하는 알고리즘을 짬
		if ("red".equals(color)) {
			result = "코로나";
		} else if ("blue".equals(color)) {
			result = "스텔라";
		} else {
			result = "하이네켄";
		}


		
		// jQuery랑은 response를 사용해서 소통해야함 ( java말고는 죄다 response로 소통해야함)
		// 한글설정
		response.setContentType("text/html;charset=UTF-8");
		
		// 받을 변수명을 print안에 넣어줌
		response.getWriter().print(result);
		// 닫아줘야함
		response.getWriter().close();

	}

}
