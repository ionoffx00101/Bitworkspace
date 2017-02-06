package openapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MovieService
 */
@WebServlet("/MovieService")
public class MovieService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MovieService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("searchMovie.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String clientId = "q01Uu7VgL08nJfpOcJ_7";//애플리케이션 클라이언트 아이디값";
		String clientSecret = "VjSox5_14m";//애플리케이션 클라이언트 시크릿값";

		// 검색하려는 영화제목을 query객체에 넣어줌
		String query = request.getParameter("query");
		

		// 한글화
		query = URLEncoder.encode(query, "UTF-8");
		// 영화제목 넣어서 url로 만들어줌
		String apiURL = "https://openapi.naver.com/v1/search/movie.xml?query=" + query;
		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("X-Naver-Client-Id", clientId);
		con.setRequestProperty("X-Naver-Client-Secret", clientSecret);

		// 네이버가 준 결과를 bufferedReader로 읽어서 넣음
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

		String result = "";
		String inputLine;
	/*	while (true) {
			String line = br.readLine();
			if (line == null) {
				break;
			}
			result += line;
		}*/
		while((inputLine = br.readLine())!=null){
			result += inputLine;
		}
		br.close();
		
		
		
		// 만든 result를 html형식으로 jsp페이지에 리턴
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(result);
		response.getWriter().close();
		
	}

}
