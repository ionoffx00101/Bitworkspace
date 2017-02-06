package com.bitacademy.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.college.College;
import com.bitacademy.college.CollegeDAO;
import com.bitacademy.dept.Dept;
import com.bitacademy.dept.DeptDAO;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Servlet implementation class StudentService
 */

public class StudentService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentService() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		try {
			if ("addStudentForm".equals(method)) {
				addStudentForm(request, response);
			} else if ("addStudent".equals(method)) {
				addStudent(request, response);
			} else if ("checkUserid".equals(method)) {
				
				checkUserid(request, response);
			} else if ("viewDeptList".equals(method)) {
				viewDeptList(request, response);
			} else {
				addStudentForm(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// 단대를 선택했을때 선택한 단대에 해당하는 학과 리스트를 전송하는 메서드
		public void viewDeptList(HttpServletRequest request,HttpServletResponse response) throws Exception {
			
			// 1.선택한 단대 번호 파라메터 colno 를 리턴받아서 변수에 저장
			// String colno=request.getParameter("colno");
			String colno = request.getParameter("colno");

			// 2.DeptDAO.selectDeptList(colno) 호출해서 선택한 단대에대한
			// 학과 리스트를 리턴받아서 ArrayList<Dept> 타입 변수에 저장
			// ArrayList<Dept> deptList=DeptDAO.selectDeptList(colno);
			ArrayList<Dept> deptList = DeptDAO.selectDeptList(colno);

			
			// 3. 응답정보의 한글 설정
			// response.setContentType("text/xml;charset=UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			
			//4.ArrayList<Dept> deptList를 xml 문자열로 변환시키는 XStream 객체 생성 및 한글설정
			XStream xstream = new XStream(new DomDriver("UTF-8"));
			
			//5.Dept클래스의 태그이름을 dept 로 설정
			xstream.alias("dept", Dept.class);
			
			//6.ArrayList<Dept> deptList를 xml 문자열로 변환해서 변수 result에 저장
			String result = xstream.toXML(deptList);
			
			// 6.변수 result를 JSP로 전송
			response.getWriter().print(result);
			
			// 7.JSP와 서블렛의 연결을 종료
			response.getWriter().close();
			
		}
	// 아이디 첵크를 선택했을때 호출되는 메서드
	public void checkUserid(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		String result = null;
		
		// 1.파라메터 userid 를 리턴받아서 변수에 저장
		// String userid=request.getParameter("userid");
		String userid = request.getParameter("userid");
		
		// 2.StudentDAO.selectStudent(1의변수) 호출해서 리턴값을 Student 타입 변수에 저장
		// Student student=StudentDAO.selectStudent(userid);
		Student student = StudentDAO.selectStudent(userid);
		
		// 3. 응답정보의 한글 설정
		// response.setContentType("text/html;charset=UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		// 4.2의 변수가 null 이면 존재 하지 안는 아이디 이므로 "사용가능한 아이디 입니다" 를
		// 변수 result에 저장
		// result="사용가능한 아이디입니다";

		// 5. 4가 아니면 존재 하는 아이디 이므로 "이미 사용중인 아이디 입니다" 를 변수 result에 저장
		// result="이미 사용중인 아이디 입니다";
		
		if (student == null)
			result = "사용 가능한 아이디입니다.";
		else
			result = "이미 사용중인 아이디 입니다.";

		// 6.변수 result를 JSP로 전송
		// response.getWriter().print(result);
		response.getWriter().print(result);

		// 7.JSP와 서블렛의 연결을 종료
		// response.getWriter().close();
		response.getWriter().close();
	}

	

	// 학생 추가 화면으로 이동
	public void addStudentForm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ArrayList<College> collegeList = null;
		ArrayList<Dept> deptList = null;

		// 1.CollegeDAO.selectCollegeList()를 호출해서
		// 리턴된 전체 단대 정보를 변수 collegeList에 저장
		collegeList = CollegeDAO.selectCollegeList();

		// 2. DeptDAO.selectDeptList("100")메서드를 호출하고
		// 리턴된 단과대학 100에 소속된 전체 학과정보를 변수 deptList에 저장
		deptList = DeptDAO.selectDeptList("100");

		// 3.1에서 조회한 전체 단과대학 리스트를 JSP로 전송하도록 설정
		// request.setAttribute(JSP에서 이 데이터를 꺼내서 출력할때 사용할 이름,JSP로 전송할 변수);
		request.setAttribute("COLLEGE_LIST", collegeList);

		// 4.2에서 조회한 100번 단과 대학에 소속된 학과 리스트를 JSP로 전송하도록 설정
		// //request.setAttribute(JSP에서 이 데이터를 꺼내서 출력할때 사용할 이름,JSP로 전송할 변수);
		request.setAttribute("DEPT_LIST", deptList);

		// 5.학생 추가 화면 페이지 /student/addStudentForm.jsp로 페이지 이동시키는
		// RequestDispatcher 객체 생성
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/student/addStudentForm.jsp");

		// 6. /student/addStudentForm.jsp 로 페이지 이동
		dispatcher.forward(request, response);

	}

	public void addStudent(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			// 1. 입력한 학생학번을 String 타입 변수에 저장
			// -request.getParameter("입력화면 addStudentForm.jsp 의 학번의 name속성의 값")
			String studno = request.getParameter("stuno");

			// 2. 입력한 이름을 String 타입 변수에 저장
			// -request.getParameter("입력화면 addStudentForm.jsp 의 이름의 name속성의 값")
			String name = request.getParameter("name");

			// 3. 입력한 아이디을 String 타입 변수에 저장
			// -request.getParameter("입력화면 addStudentForm.jsp 아이디의 name속성의 값")
			String userid = request.getParameter("userid");

			// 4. 입력한 비밀번호을 String 타입 변수에 저장
			// -request.getParameter("입력화면 addStudentForm.jsp 월급의  name속성의 값")
			String pw = request.getParameter("pw");

			// 8. 선택한 학과번호을 String 타입 변수에 저장
			// -request.getParameter("입력화면 addStudentForm.jsp 학과번호의 name속성의 값")
			String deptno = request.getParameter("deptno");

			// B. Student 객체 생성
			Student student = new Student();

			// C. B객체의 속성에 1~7변수의 값 저장
			student.studno = studno;
			student.name = name;
			student.userid = userid;
			student.pw = pw;

			// D.Dept 객체 생성
			Dept dept = new Dept();
			// E. D객체의 deptno 속성에 8의 학과번호 저장
			dept.deptno = deptno;
			// F. B객체에 D 객체 저장
			// - B객체.dept=D객체;
			student.dept = dept;

			// G. StudentDAO.insertStudent(B객체)호출
			StudentDAO.insertStudent(student);
			// H. StudentService?method=addStudentForm 로 이동
			// - RequestDispatcher rd=request.getRequestDispatcher(
			// "StudentService?method=addStudentForm");
			// - rd.forward(request,response);
			RequestDispatcher dispatcher = request
					.getRequestDispatcher("StudentService?method=addStudentForm");
			dispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
