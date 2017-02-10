package com.bitacademy.professor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class ProfessorService
 */
@Controller
public class ProfessorService {
	public static final long serialVersionUID = 1L;
	/* 실습1 : 스프링으로 부터 ProfessorDAO를 주입받도록 설정한다
	 * 
	 * @Resource(name="dispatcher-servlet.xml에 선언한 ProfessorDAO 객체의 이름") */
	@Resource(name = "profDAO")
	public ProfessorDAO professorDAO;
	/* 실습1 : 스프링으로 부터 DeptDAO를 주입받도록 설정한다
	 * 
	 * @Resource(name="dispatcher-servlet.xml에 선언한 DeptDAO 객체의 이름") */
	@Resource(name = "deptDAO")
	public DeptDAO deptDAO;

	public ProfessorService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/ProfessorService")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 리퀘스트 값 한글화
		request.setCharacterEncoding("UTF-8");
		// 리퀘스트에서 메소드라는 이름을 가진 파라미터를 찾아서 값을 가져옴
		String method = request.getParameter("method");
		// 메소드값으로 사용자가 원하는 페이지를 구분해서 해당 메소드로 이동 시킴
		if ("viewProfessorList".equals(method)) {
			viewProfessorList(request, response);
		} else if ("viewProfessor".equals(method)) {
			viewProfessor(request, response);
		} else if ("editProfessorForm".equals(method)) {
			editProfessorForm(request, response);
		} else if ("editProfessor".equals(method)) {
			editProfessor(request, response);
		} else if ("addProfessorForm".equals(method)) {
			addProfessorForm(request, response);
		} else if ("addProfessor".equals(method)) {
			addProfessor(request, response);
		} else if ("removeProfessor".equals(method)) {
			removeProfessor(request, response);
		} else {
			viewProfessorList(request, response);
		}

	}

	public void editProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 입력한 교수학번을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessorForm.jsp 의 학번의 name속성의 값")
		String profno = request.getParameter("profno");
		//2. 입력한 이름을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessorForm.jsp 의 이름의 name속성의 값")
		String name = request.getParameter("name");
		//3. 입력한 아이디을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessor.jsp 아이디의 name속성의 값")
		String userid = request.getParameter("userid");
		//4. 입력한 월급을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessorForm.jsp 월급의  name속성의 값")
		String sal = request.getParameter("sal");
		//5. 입력한 성과급을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessorForm.jsp 성과급의 name속성의 값")
		String comm = request.getParameter("comm");
		//6. 입력한 직책을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessorForm.jsp 직책의 name속성의 값")
		String postion = request.getParameter("position");
		//7. 입사일을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessorForm.jsp 입사일의 name속성의 값")
		String hiredate = request.getParameter("hiredate");
		//8. 선택한 학과번호을 String 타입 변수에 저장
		//-request.getParameter("입력화면 editProfessorForm.jsp 학과번호의 name속성의 값")
		String detpno = request.getParameter("deptno");

		//B. Professor 객체 생성
		Professor professor = new Professor();

		//C. B객체의 속성에 1~7의 교수번호,이름,아이디,월급,성과급,직책,입사일을 저장
		//  String 을 Long 으로 바꾸기 위해서는 Long.parseLong(String변수)
		professor.profno = Long.parseLong(profno);
		professor.name = name;
		professor.userid = userid;
		professor.sal = Long.parseLong(sal);
		professor.comm = comm;
		professor.position = postion;
		//  String(년도-월-일 형식) 을 java.sql.Date로 바꾸기 위해서는
		//   c.1.문자열에 저장된 날짜의 형식을 저장하는 SimpleDateFormat 함수 생성
		//       yyyy:년도 4자리
		//       MM: 월 2자리
		//      dd: 날짜 2자리
		//    SimpleDateFormat transFormat =
		//        new SimpleDateFormat("yyyy-MM-dd");

		//    c.2 7의 문자열을 java.utilDate로 변환
		//   Date hiredate = transFormat.parse(7의 변수);

		//    c.3 c.2의 변수를 java.sql.Date로 변환
		//java.util.Date에 저장된 날짜를 java.sql.Date로 변환
		// new java.sql.Date(hiredate.getTime());

		//해서 Professor 객체의 hiredate속성에 저장
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate2 = transFormat.parse(hiredate);
		professor.hiredate = new java.sql.Date(hiredate2.getTime());

		//D.Dept 객체 생성
		Dept dept = new Dept();
		//E. D객체의 deptno 속성에 8의 학과번호 저장
		////  String 을 Long 으로 바꾸기 위해서는 Long.parseLong(String변수)
		dept.deptno = Long.parseLong(detpno);

		//F. B객체에 D 객체 저장
		//-B객체.dept=D객체;
		professor.dept = dept;

		//G. professorDAO.updateProfessor(B객체)호출
		professorDAO.updateProfessor(professor);

		//H. ProfessorService?method=viewProfessor&profno=교수번호 로 이동
		//-		RequestDispatcher rd=request.getRequestDispatcher(
		//			"ProfessorService?method=viewProfessor&profno="+B객체의 profno 속성);
		//- 		rd.forward(request,response);

		RequestDispatcher rd = request.getRequestDispatcher("ProfessorService?method=viewProfessor&profno=" + professor.profno);
		rd.forward(request, response);
	}

	public void addProfessorForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. deptDAO.selectDeptrList()메서드를 호출하고 
		//리턴된 전체 학과정보를  List에 저장
		List<Dept> list = deptDAO.selectDeptList();

		//3.1의 List를 request에 저장
		// -  request.setAttribute("JSP에서 사용할 이름",1변수);
		request.setAttribute("DEPT_LIST", list);

		//4./professor/addProfessorForm.jsp로 페이지 이동
		/* RequestDispatcher rd=request.getRequestDispatcher("/professor/addProfessorForm.jsp");
		 * rd.forward(request,response); */
		RequestDispatcher rd = request.getRequestDispatcher("/professor/addProfessorForm.jsp");
		rd.forward(request, response);
	}

	public void addProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 입력한 교수학번을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessorForm.jsp 의 학번의 name속성의 값")
		String profno = request.getParameter("profno");

		//2. 입력한 이름을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessorForm.jsp 의 이름의 name속성의 값")
		String name = request.getParameter("name");

		//3. 입력한 아이디을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessor.jsp 아이디의 name속성의 값")
		String userid = request.getParameter("userid");

		//4. 입력한 월급을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessorForm.jsp 월급의  name속성의 값")
		String sal = request.getParameter("sal");

		//5. 입력한 성과급을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessorForm.jsp 성과급의 name속성의 값")
		String comm = request.getParameter("comm");

		//6. 입력한 직책을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessorForm.jsp 직책의 name속성의 값")
		String position = request.getParameter("position");

		//7. 입사일을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessorForm.jsp 입사일의 name속성의 값")
		String hiredate = request.getParameter("hiredate");

		//8. 선택한 학과번호을 String 타입 변수에 저장
		//-request.getParameter("입력화면 addProfessorForm.jsp 학과번호의 name속성의 값")
		String deptno = request.getParameter("deptno");

		//B. Professor 객체 생성
		Professor professor = new Professor();

		//C. B객체의 속성에 1~7의 교수번호,이름,아이디,월급,성과급,직책,입사일을 저장
		//  String 을 Long 으로 바꾸기 위해서는 Long.parseLong(String변수)
		professor.profno = Long.parseLong(profno);
		professor.name = name;
		professor.userid = userid;
		professor.sal = Long.parseLong(sal);
		professor.comm = comm;
		professor.position = position;
		System.out.println("2222");
		//  String(년도-월-일 형식) 을 java.sql.Date로 바꾸기 위해서는
		//   c.1.문자열에 저장된 날짜의 형식을 저장하는 SimpleDateFormat 함수 생성
		//       yyyy:년도 4자리
		//       MM: 월 2자리
		//      dd: 날짜 2자리
		//    SimpleDateFormat transFormat =
		//        new SimpleDateFormat("yyyy-MM-dd");

		//    c.2 7의 문자열을 java.utilDate로 변환
		//   Date hiredate = transFormat.parse(7의 변수);

		//    c.3 c.2의 변수를 java.sql.Date로 변환
		//java.util.Date에 저장된 날짜를 java.sql.Date로 변환
		// new java.sql.Date(hiredate.getTime());

		//해서 Professor 객체의 hiredate속성에 저장
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date hiredate2 = transFormat.parse(hiredate);
		professor.hiredate = new java.sql.Date(hiredate2.getTime());

		//D.Dept 객체 생성
		Dept dept = new Dept();

		//E. D객체의 deptno 속성에 8의 학과번호 저장
		////  String 을 Long 으로 바꾸기 위해서는 Long.parseLong(String변수)
		dept.deptno = Long.parseLong(deptno);

		//F. B객체에 D 객체 저장
		//-B객체.dept=D객체;
		professor.dept = dept;
		System.out.println(professor);
		//G. professorDAO.updateProfessor(B객체)호출
		professorDAO.updateProfessor(professor);
		//H. ProfessorService?method=viewProfessor&profno=교수번호 로 이동

		//-		RequestDispatcher rd=request.getRequestDispatcher(
		//			"ProfessorService?method=viewProfessor&profno="+B객체의 profno 속성);
		//- 		rd.forward(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("ProfessorService?method=viewProfessor&profno=" + professor.profno);
		rd.forward(request, response);

	}

	public void removeProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. 교수번호 리턴받아서 String변수에 저장
		// request.getParameter("profno")
		String profno = request.getParameter("profno");

		//2.professorDAO.deleteProfessor(profno)  호출
		professorDAO.deleteProfessor(Long.parseLong(profno));

		//3.전체 교수 조회 화면으로 이동
		//   RequestDispatcher rd=request.getRequestDispatcher(
		//			"ProfessorService?method=viewProfessorList");
		// 		rd.forward(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("ProfessorService?method=viewProfessorList");
		rd.forward(request, response);

	}

	//전체 교수 조회 
	public void viewProfessorList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1. professorDAO.selectProfessorList()메서드를 호출하고 
		//리턴된 전체 교수정보를  List에 저장
		List<Professor> ProfessorList = professorDAO.selectProfessorList();
		//3.2의 List를 request에 저장
		//  request.setAttribute("JSP에서 사용할 List의 이름",1의 변수);
		request.setAttribute("PROFESSOR_LIST", ProfessorList);
		//4./professor/viewProfessorList.jsp로 페이지 이동
		//  RequestDispatcher rd=request.getRequestDispatcher("/professor/viewProfessorList.jsp");
		//  rd.forward(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/professor/viewProfessorList.jsp");
		rd.forward(request, response);

	}

	//교수1명조회
	public void viewProfessor(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 1.requst 에서 profno파라메터를 리턴받아서 String 타입 변수에 저장
		//   request.getParameter("profno")
		String profno = request.getParameter("profno");
		//2. professorDAO.selectProfessor(1의 변수)메서드를 호출해서
		//교수정보를 리턴받고 리턴값을 Professor객체에저장
		Professor professor = professorDAO.selectProfessor(Long.parseLong(profno));
		//4.request에 2의 리턴값 저장
		//  request.setAttribute("JSP에서 사용할 Professor객체의 이름",2의 Professor객체)
		request.setAttribute("PROFESSOR", professor);
		//5./professor/viewProfessor.jsp로 페이지 이동
		//  RequestDispatcher rd=request.getRequestDispatcher("/professor/viewProfessor.jsp");
		//  rd.forward(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/professor/viewProfessor.jsp");
		rd.forward(request, response);
	}

	public void editProfessorForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//1.	requst 에서 profno파라메터를 리턴받아서 String 변수에 저장해서 수정하려는 교수번호를 리턴받아서 변수에 저장
		//      request.getParameter("profno")
		String profno = request.getParameter("profno");
		//2.	professorDAO.selectProfessor(교수번호) 호출해서 수정하려는 교수 정보 조회해서 Professor 타입 변수에 저장
		Professor Professor = professorDAO.selectProfessor(Long.parseLong(profno));
		//3.	2의 교수정보를 request에 저장
		//      request.setAttribute("JSP에서 사용할 이름",2의 Professor객체)
		request.setAttribute("PROFESSOR", Professor);
		//4.	DepartmentDAO.selectDepartmentList()호출 해서 전체 학과 리스트 조회해서 List타입 변수에 저장
		List<Dept> DeptList = deptDAO.selectDeptList();
		//5.	4의 전체 학과리스트를 request에 저장
		//      request.setAttribute("JSP에서 사용할 List의 이름",4의 List 객체);
		request.setAttribute("DEPT_LIST", DeptList);
		//6.	/professor/editProfessorForm.jsp로 페이지 이동
		//  RequestDispatcher rd=request.getRequestDispatcher("/professor/editProfessorForm.jsp");
		//  rd.forward(request,response);
		RequestDispatcher rd = request.getRequestDispatcher("/professor/editProfessorForm.jsp");
		rd.forward(request, response);

	}

}
