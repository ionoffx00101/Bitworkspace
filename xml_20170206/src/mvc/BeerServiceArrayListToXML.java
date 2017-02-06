package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Servlet implementation class BeerService
 */
@WebServlet("/BeerServiceArrayListToXML")
public class BeerServiceArrayListToXML extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BeerServiceArrayListToXML() {
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

		// beer객체들을 넣을 beerList생성
		ArrayList<Beer> beerList = new ArrayList<Beer>();
		
		// beer 객체 생성
		Beer b1 = new Beer();
		Beer b2 = new Beer();
		// beer 객체에 데이터 넣기
		if ("red".equals(color)) {
			b1.bname = "기네스";
			b1.brand = "기네스";
			b1.price = "6000";
			b2.bname = "하이네켄";
			b2.brand = "nope";
			b2.price = "6000";
			
		} else if ("blue".equals(color)) {
			b1.bname = "맺규";
			b1.brand = "nope";
			b1.price = "6000";
			b2.bname = "스텔라";
			b2.brand = "yes";
			b2.price = "7000";
		} else {
			b1.bname = "어나덥머스";
			b1.brand = "ㅁㄴㅇ";
			b1.price = "9000";
			b2.bname = "규규규";
			b2.brand = "뮤규뮥";
			b2.price = "55300";
		}
		// beerList에 데이터가 담긴 beer 넣기
		beerList.add(b1);
		beerList.add(b2);
		
		// 한글 설정 하기
		XStream xstream = new XStream(new DomDriver("UTF-8"));
		
		// Beer 클래스는 Xml문서에서 태그이름을 beer로 할것이다.
		xstream.alias("beer",Beer.class);
		
		// ArrayList 객체를 XML문자열로 바꾸고 그걸 result객체에 넣음  
		String result = xstream.toXML(beerList);
		
		// 보낼 contenttype설정
		response.setContentType("text/html;charset=UTF-8");
		
		// 받을 변수명을 print안에 넣어줌
		response.getWriter().print(result);
		
		// 닫아줘야함
		response.getWriter().close();

	}

}
