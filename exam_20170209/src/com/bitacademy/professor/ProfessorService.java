package com.bitacademy.professor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProfessorService
 */

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

		// 리퀘스트 한글화
		request.setCharacterEncoding("UTF-8");
		// 리퀘스트안에 메소드라는 이름을 가진 파라미터 값 가져오기와서 메소드라는 변수에 넣기
		String method = request.getParameter("method");
		// 리턴할 주소값을 넣기 위한 변수 만들어두기
		String requestUrl = null;

		try {
			if ("viewProfessorList".equals(method)) {
				requestUrl = viewProfessorList(request, response);
			} else if ("viewProfessor".equals(method)) {
				requestUrl = viewProfessor(request, response);
			} else if ("editProfessorForm".equals(method)) {
				requestUrl = editProfessorForm(request, response);
			} else if ("editProfessor".equals(method)) {
				requestUrl = editProfessor(request, response);
			} else if ("addProfessorForm".equals(method)) {
				requestUrl = addProfessorForm(request, response);
			} else if ("addProfessor".equals(method)) {
				requestUrl = addProfessor(request, response);
			} else if ("removeProfessor".equals(method)) {
				requestUrl = removeProfessor(request, response);
			} else {
				requestUrl = viewProfessorList(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 위에 메소드를 거치면서 사용자가 원하는 값들을 가지고 이동함
		RequestDispatcher rd = request.getRequestDispatcher(requestUrl);
		rd.forward(request, response);
	}

	private String editProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 리퀘스트 안에 파라미터속을 타고온 모든 교수정보값들을 뽑아서 각각 변수에 저장시킴 
		String profno = request.getParameter("profno");
		String profname = request.getParameter("name");
		String userid = request.getParameter("userid");
		String position = request.getParameter("position");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String hiredate = request.getParameter("hiredate");

		// 그 정보들 속에는 학과 정보도 있는 데 학과 정보를 넣으려면 비어있는 학과 객체도 만들어줘야함
		String deptno = request.getParameter("deptno");

		Dept dept = new Dept();
		dept.deptno = Long.parseLong(deptno); // String > Long으로 변환시켜줘야한다

		// 위에 뽑아낸 교수 정보들과 학과번호가 담긴 학과객체를 비어있는 교수 객체에 넣어줌
		Professor professor = new Professor();
		professor.profno = Long.parseLong(profno); // String > Long으로 변환시켜줘야한다
		professor.name = profname;
		professor.userid = userid;
		professor.position = position;
		professor.sal = Long.parseLong(sal); // String > Long으로 변환시켜줘야한다
		professor.comm = comm;
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date transhiredate = transFormat.parse(hiredate); // String > java.sql.Date으로 변환시켜줘야한다
		professor.hiredate = new java.sql.Date(transhiredate.getTime());
		
		professor.dept = dept;

		// 수정메소드를 호출해서 모든 정보를 넣은 교수객체를 넣어주자.
		ProfessorDAO.updateProfessor(professor);

		// 사용자가 요청한걸 다 했으니 페이지로 돌아가자
		return "ProfessorService?method=viewProfessor&profno=" + profno;

	}
 
	private String addProfessorForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// dept리스트 가져오기
		List<Dept> deptList = DeptDAO.selectDeptList();
		// request에 dept리스트 넣어주기
		request.setAttribute("deptList", deptList);

		return "/professor/addProfessorForm.jsp";

	}

	private String addProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 리퀘스트 안에 파라미터속을 타고온 모든 교수정보값들을 뽑아서 각각 변수에 저장시킴 
		String profno = request.getParameter("profno");
		String profname = request.getParameter("name");
		String userid = request.getParameter("userid");
		String position = request.getParameter("position");
		String sal = request.getParameter("sal");
		String comm = request.getParameter("comm");
		String hiredate = request.getParameter("hiredate");

		// 그 정보들 속에는 학과 정보도 있는 데 학과 정보를 넣으려면 비어있는 학과 객체도 만들어줘야함
		String deptno = request.getParameter("deptno");

		Dept dept = new Dept();
		dept.deptno = Long.parseLong(deptno); // String > Long으로 변환시켜줘야한다

		// 위에 뽑아낸 교수 정보들과 학과번호가 담긴 학과객체를 비어있는 교수 객체에 넣어줌
		Professor professor = new Professor();
		professor.profno = Long.parseLong(profno); // String > Long으로 변환시켜줘야한다
		professor.name = profname;
		professor.userid = userid;
		professor.position = position;
		professor.sal = Long.parseLong(sal); // String > Long으로 변환시켜줘야한다
		professor.comm = comm;

		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date transhiredate = transFormat.parse(hiredate); // String > java.sql.Date으로 변환시켜줘야한다
		professor.hiredate = new java.sql.Date(transhiredate.getTime());
		
		professor.dept = dept;
		
		// 데이터 추가 메소드를 호출해서 모든 정보를 넣은 교수객체를 넣어주자.
		ProfessorDAO.insertProfessor(professor);
		
		return "ProfessorService?method=viewProfessor&profno=" + profno;
		
	}

	private String removeProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 교수번호 리턴받아서 String변수에 저장
		// request.getParameter("profno")
		//2.ProfessorDAO.deleteProfessor(Long.parseLong(profno))  호출
		//3.전체 교수 조회 화면으로 이동
		//   RequestDispatcher rd=request.getRequestDispatcher(
		//			"ProfessorService?method=viewProfessorList");
		// 		rd.forward(request,response);
		
		// 리퀘스트에 넘어오는 교수번호 받아오기
		Long profno = Long.parseLong(request.getParameter("profno"));
		// 해당 교수 번호랑 일치하는 데이터를 삭제하는 메소드 삭제
		ProfessorDAO.deleteProfessor(profno);
		// 삭제 했으니 페이지 이동
		return "ProfessorService?method=viewProfessorList";
	}

	//전체 교수 조회 
	public String viewProfessorList(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		List<Professor> ProfessorList = ProfessorDAO.selectProfessorList();
		
		request.setAttribute("PROFESSOR_LIST", ProfessorList);

		return "/professor/viewProfessorList.jsp";
	}

	//교수1명조회
	public String viewProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String profno = request.getParameter("profno");
	
		Professor professor = ProfessorDAO.selectProfessor(Long.parseLong(profno));
		
		request.setAttribute("PROFESSOR", professor);

		return "/professor/viewProfessor.jsp";
	}

	public String editProfessorForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String profno = request.getParameter("profno");
		
		Professor Professor = ProfessorDAO.selectProfessor(Long.parseLong(profno));
		
		request.setAttribute("PROFESSOR", Professor);
		//4.	DepartmentDAO.selectDepartmentList()호출 해서 전체 학과 리스트 조회해서 List타입 변수에 저장
		List<Dept> DeptList = DeptDAO.selectDeptList();
		//5.	4의 전체 학과리스트를 request에 저장
		//      request.setAttribute("JSP에서 사용할 List의 이름",4의 List 객체);
		request.setAttribute("DEPT_LIST", DeptList);
		//6.	/professor/editProfessorForm.jsp로 페이지 이동
		//  RequestDispatcher rd=request.getRequestDispatcher("/professor/editProfessorForm.jsp");
		//  rd.forward(request,response);
		/* RequestDispatcher rd = request.getRequestDispatcher("/professor/editProfessorForm.jsp");
		 * rd.forward(request, response); */

		return "/professor/editProfessorForm.jsp";

	}

}
