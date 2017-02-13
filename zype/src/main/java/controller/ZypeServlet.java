package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import service.BoardService;
import service.MemberService;

/**
 * Servlet implementation class ZypeServlet
 */
@Controller
public class ZypeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private BoardService bs;
	@Autowired
	private MemberService ms;
	
	
	public ZypeServlet() {
		super();
	}
	
	@RequestMapping()
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 리퀘스트 한글화
		request.setCharacterEncoding("UTF-8");
		// 리퀘스트안에 메소드라는 이름을 가진 파라미터 값 가져오기와서 메소드라는 변수에 넣기
		String method = request.getParameter("method");
		// 리턴할 주소값을 넣기 위한 변수 만들어두기
		String requestUrl = null;

		try {
			if ("boardList".equals(method)) {
				requestUrl = bs.boardList(request, response);
			} else {
				requestUrl = bs.boardList(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 위에 메소드를 거치면서 사용자가 원하는 값들을 가지고 이동함
		RequestDispatcher rd = request.getRequestDispatcher(requestUrl);
		rd.forward(request, response);
	}

}
