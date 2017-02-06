package com.bitacademy.job;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JobService
 */
public class JobService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JobService() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		try {
			if ("searchJobForm".equals(method)) {
				searchJobForm(request, response);
			} else if ("searchJobList".equals(method)) {
				searchJobList(request, response);
			} else {
				searchJobForm(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchJobForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher("/job/searchJobList.jsp");
		rd.forward(request, response);

	}

	private void searchJobList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.입력한 검색어인 "query" 파라메터를 변수에 저장
		String query = request.getParameter("query");

		//2.입력한 검색어를 UTF-8타입 문자열로 바꿔서 변수 query에 저장
		query = URLEncoder.encode(query, "UTF-8");

		//3.사람인 open api의 url을 변수 serviceUrl에 저장
		String serviceUrl = "http://api.saramin.co.kr/job-search?keywords=" + query;

		//4.3의 ServiceUrl에 접속하는 URL 객체 생성 하고 저장
		URL requestUrl = new URL(serviceUrl);

		// 사람인 openapi 접속

		//HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();

		//5. 4의 URL에서 xml 데이터를 가져오는 BufferedReader객체 생성
		BufferedReader br = new BufferedReader(new InputStreamReader(requestUrl.openConnection().getInputStream(), "UTF-8"));

		String result = "";

		while (true) {
			//6. 사람인에서 전송한 xml 문서를 1줄 읽어서 변수 line에 저장	
			String line = br.readLine();

			//7. 6의 변수 line이 null 이면 반복 종료	
			if (line == null) {
				break;
			}

			//8.result에 line 추가
			result += line;
		}
		//9.사람인과 연결 종료
		br.close();

		//10.응답정보의 한글 설정
		response.setContentType("text/html;charset=UTF-8");
		//11.result를 JSP로 리턴
		response.getWriter().print(result);
		//12.JSP와 연결 종료
		response.getWriter().close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
