package com.bitacademy.student;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bitacademy.college.College;
import com.bitacademy.college.CollegeDAO;
import com.bitacademy.dept.Dept;
import com.bitacademy.dept.DeptDAO;

/**
 * Servlet implementation class StudentService
 */
//@WebServlet("/student/StudentService")  web.xml에 설정 바꾸고 싶군 
public class StudentService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentService() {
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
		
		//method파라미터로 사용자가 요청하는 페이지(기능) 구별해서 해당 메소드를 호출해줌
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		try {
			if ("addStudentForm".equals(method)) {
				addStudentForm(request, response);

			} else if ("addStudent".equals(method)) {
				addStudent(request, response);
			} else {
				addStudentForm(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//학생 추가 화면으로 이동
	public void addStudentForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ArrayList<College> collegeList = null;
		ArrayList<Dept> deptList = null;

		//1.CollegeDAO.selectCollegeList()를 호출해서 리턴된 전체 단대 정보를 변수 collegeList에 저장
		collegeList = CollegeDAO.selectCollegeList();

		//2. DeptDAO.selectDeptList("100")메서드를 호출하고 리턴된 단과대학 100에 소속된 전체 학과정보를  변수 deptList에 저장
		deptList = DeptDAO.selectDeptList("100");

		//3.1에서 조회한 전체 단과대학 리스트를 JSP로 전송하도록 설정 request.setAttribute(JSP에서 이 데이터를 꺼내서 출력할때 사용할 이름,JSP로 전송할 변수);
		request.setAttribute("COLLEGE_LIST", collegeList);

		//4.2에서 조회한 100번 단과 대학에 소속된 학과 리스트를 JSP로 전송하도록 설정 request.setAttribute(JSP에서 이 데이터를 꺼내서 출력할때 사용할 이름,JSP로 전송할 변수);
		request.setAttribute("DEPT_LIST", deptList);

		//5.학생 추가 화면 페이지 /student/addStudentForm.jsp로 페이지 이동시키는 RequestDispatcher 객체 생성
		RequestDispatcher rd = request.getRequestDispatcher("/student/addStudentForm.jsp");

		//6. /student/addStudentForm.jsp 로 페이지 이동
		rd.forward(request, response);

	}

	public void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//입력한 학생 정보 받아서 저장
		
		String studno = request.getParameter("studno");
		String name = request.getParameter("name");
		String userid = request.getParameter("userid");
		String pw = request.getParameter("pw");
		String deptno = request.getParameter("deptno");/* no인데 name옴 */
		
		//B. Student 객체 생성
		//C. st 저장
		Student student = new Student();
		student.studno = studno;
		student.name = name;
		student.userid = userid;
		student.pw = pw;
		// ?
		// student.dept.setDeptno(deptno);
		
		//D.Dept 객체 생성
		//E. dept에 deptno 저장
		Dept dept = new Dept();
		dept.setDeptno(deptno);
		
		// student에 deptno가 들어간 dept정보 저장
		student.dept = dept;
		
		
		/*
		 * //dept.setDeptno();
		String realdeptno = DeptDAO.selectDeptListName(deptno);
		
		dept.setDeptno(realdeptno);
		student.dept = dept;
		*/
		
		
		//G. StudentDAO.insertStudent(B객체)호출
		// try문이랑 throw랑 고르라고 뜬다
		try {
			
			StudentDAO.insertStudent(student);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//H. StudentService?method=addStudentForm 로 이동
		RequestDispatcher rd = request.getRequestDispatcher("StudentService?method=addStudentForm");
		try {
			rd.forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
