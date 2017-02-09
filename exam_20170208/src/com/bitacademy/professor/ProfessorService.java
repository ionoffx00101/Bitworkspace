package com.bitacademy.professor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfessorService
 */
/* @WebServlet(urlPatterns="/ProfessorService") */
public class ProfessorService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProfessorService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 파라미터로 온 값 한글화
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		String urlrequest = null;
		try {
			if ("viewProfessorList".equals(method)) {
				urlrequest = viewProfessorList(request, response);
			} else if ("viewProfessor".equals(method)) {
				urlrequest = viewProfessor(request, response);
			} else if ("editProfessorForm".equals(method)) {
				urlrequest = editProfessorForm(request, response);
			} else {
				urlrequest = viewProfessorList(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 웹페이지로 가기
		RequestDispatcher rd = request.getRequestDispatcher(urlrequest);
		rd.forward(request, response);
	}

	//전체 교수 조회 
	public String viewProfessorList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//1. ProfessorDAO.selectProfessorList()메서드를 호출하고 
		//리턴된 전체 교수정보를  ArrayList에 저장
		//3.2의 ArrayList를 request에 저장
		//  request.setAttribute("JSP에서 사용할 ArrayList의 이름",1의 변수);
		//4./professor/viewProfessorList.jsp로 페이지 이동
		//  RequestDispatcher rd=request.getRequestDispatcher("/professor/viewProfessorList.jsp");
		//  rd.forward(request,response);

		// 교수 리스트 만들기 (형변환 해줘야한다)
		ArrayList<Professor> professorList = (ArrayList<Professor>) ProfessorDAO.selectProfessorList();
		// 리스트를 리퀘스트 객체에 담기
		request.setAttribute("professorList", professorList);

		/* // 웹페이지로 가기
		 * RequestDispatcher rd = request.getRequestDispatcher("/professor/viewProfessorList.jsp");
		 * rd.forward(request, response); */

		return "/professor/viewProfessorList.jsp";

	}

	//교수1명조회
	public String viewProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1.requst 에서 profno파라메터를 리턴받아서 String 타입 변수에 저장
		//   request.getParameter("profno")
		//2. ProfessorDAO.selectProfessor(1의 변수)메서드를 호출해서
		//교수정보를 리턴받고 리턴값을 Professor객체에저장
		//4.request에 2의 리턴값 저장
		//  request.setAttribute("JSP에서 사용할 Professor객체의 이름",2의 Professor객체)
		//5./professor/viewProfessor.jsp로 페이지 이동
		//  RequestDispatcher rd=request.getRequestDispatcher("/professor/viewProfessor.jsp");
		//  rd.forward(request,response);

		// 웹페이지에서 파라미터에 넣어 보낸 profno값을 받기
		Long profno = Long.parseLong(request.getParameter("profno"));
		// 받은 번호로 교수 정보 조회해서 새로 만든 교수 한줄 객체에 집어넣기
		Professor professor = ProfessorDAO.selectProfessor(profno);
		// 리퀘스트에 검색결과가 담긴 교수정보를 담기
		request.setAttribute("professor", professor);
		/* // 웹페이지로 보내기
		 * RequestDispatcher rd = request.getRequestDispatcher("professor/viewProfessor.jsp");
		 * rd.forward(request, response); */

		return "professor/viewProfessor.jsp";
	}

	public String editProfessorForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//1.	requst 에서 profno파라메터를 리턴받아서 String 변수에 저장해서 수정하려는 교수번호를 리턴받아서 변수에 저장
		//      request.getParameter("profno")
		//2.	ProfessorDAO.selectProfessor(교수번호) 호출해서 수정하려는 교수 정보 조회해서 Professor 타입 변수에 저장
		//3.	2의 교수정보를 request에 저장
		//      request.setAttribute("JSP에서 사용할 이름",2의 Professor객체)
		//4.	DepartmentDAO.selectDepartmentList()호출 해서 전체 학과 리스트 조회해서 ArrayList타입 변수에 저장
		//5.	4의 전체 학과리스트를 request에 저장
		//      request.setAttribute("JSP에서 사용할 ArrayList의 이름",4의 ArrayList 객체);
		//6.	/professor/editProfessorForm.jsp로 페이지 이동
		//  RequestDispatcher rd=request.getRequestDispatcher("/professor/editProfessorForm.jsp");
		//  rd.forward(request,response);

		// 파라미터로 온 값들을 받아서 저장해두기
		Long profno = Long.parseLong(request.getParameter("profno"));
		// profno에 해당하는 교수 정보를 찾아와서 빈 교수 객체에 저장하기
		Professor professor = ProfessorDAO.selectProfessor(profno);
		// request에 교수 객체 담기
		request.setAttribute("professor", professor);

		// 전체 학과 리스트 불러와서 빈 dept기반의 리스트에 담기
		List<Dept> deptList = DeptDAO.selectDeptList();
		// deptList가 담아진 걸 request에 넣어 보내기
		request.setAttribute("deptList", deptList);

		/* // 웹페이지로 보내기
		 * RequestDispatcher rd = request.getRequestDispatcher("/professor/editProfessorForm.jsp");
		 * rd.forward(request, response); */

		return "/professor/editProfessorForm.jsp";

	}

}
