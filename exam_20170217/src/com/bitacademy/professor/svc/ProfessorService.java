package com.bitacademy.professor.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.professor.dao.DeptDAO;
import com.bitacademy.professor.dao.ProfessorDAO;
import com.bitacademy.professor.vo.Professor;
/*
 비지니스 로직을 처리하는 클래스
웹에서 비지니스 로직을 처리 할것이기 때문에
@Controll 어노 테이션 필요
 */
@Controller
public class ProfessorService implements IProfessorService
{
	@Autowired
	private ProfessorDAO professorDAO;

	@Autowired
	private DeptDAO deptDAO;

	@Override
	/// viewProfessorList.do일때 실행되도록 설정
	@RequestMapping("viewProfessorList") // /viewProfessorList.do
	public ModelAndView viewProfessorList()
	{
		// 1.professorDAO의 findAll() 메서드를 호출해서 전체 교수 정보 조회하고 조회결과를 변수에 저장
		// List<Professor> professorList = professorDAO.findAll();
		// 2.ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();
		/*
		 * 3. 1의 조회결과를 JSP로 보내도록 2객체 설정
		 *   설정시 JSP에서 사용할 이름과  저장할 객체를 설정
		 * addObject("JSP로 보낼이름",전송할객체);
		 */
		mav.addObject("PROFESSOR_LIST", professorDAO.findAll());
		// 4. viewProfessorList.jsp로 이동하도록 2객체 설정
		mav.setViewName("/professor/viewProfessorList.jsp");
		// 5. 2객체 리턴  
		return mav;
	}
	// 교수 1명 조회
	/*
	 * 매개변수 profno에 조회하고자 하는 교수 번호가 저장되 있음
	 */
	@Override
	// viewProfessor.do 일때 실행되도록 설정 필요
	@RequestMapping("viewProfessor") // /viewProfessor.do
	public ModelAndView viewProfessor(Long profno)
	{
		// 1.professorDAO의 findOne(profno) 를 호출해서
		// 교수번호가 일치하는 교수 정보 조회후 변수에 저장
		// Professor professor = professorDAO.findOne(profno);
		// 2. ModelAndView 객체 생성
		ModelAndView mav = new ModelAndView();
		/*
		 * 3. 2객체에 1의 교수정보를 JSP로 전송하도록 설정
		 * addObject("JSP로 보낼이름",전송할객체);
		 */
		mav.addObject("PROFESSOR", professorDAO.findOne(profno));
		// 4. 2객체에 viewProfessor.jsp로 이동하도록 설정
		mav.setViewName("/professor/viewProfessor.jsp");
		// 5. 2객체 리턴  
		return mav;
	}

	@RequestMapping("addProfessorForm")
	@Override
	public ModelAndView addProfessorForm()
	{
		// 모뷰 객체 생성
		ModelAndView mav = new ModelAndView();
		// 모뷰에 데이터 넣기 - 전체 학과 리스트
		mav.addObject("deptList", deptDAO.findAll());
		// 모뷰 갈 길 정해주기
		mav.setViewName("/professor/addProfessorForm.jsp");
		// 모뷰 보내기
		return mav;
	}

	@RequestMapping("addProfessor")
	@Override
	public ModelAndView addProfessor(Professor professor)
	{
		// 교수 데이터 저장
		professorDAO.save(professor);
		
		// 모뷰 객체 생성
		ModelAndView mav = new ModelAndView();
		// 모뷰 갈 길 정해주기
		mav.setViewName("redirect:/viewProfessorList"); // 될지 잘 모르겠다.
		// 모뷰 보내기
		return mav;
	}

}
