package com.bitacademy.professor.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.professor.dao.ProfessorDAO;

@Controller
public class ProfessorService implements IProfessorService
{

	@Autowired // inject 쓰고싶은데 왜 안뜨지
	ProfessorDAO professorDAO;

	@RequestMapping("viewProfessorList") // /viewProfessorList.do
	@Override
	public ModelAndView viewProfessorList()
	{
		// 빈 모뷰 객체 생성
		ModelAndView mav = new ModelAndView();

		// 빈 모뷰 객체에 이름표 붙여서 데이터 집어넣기
		// 교수 전체 정보 리스트를 받아서 넣음
		mav.addObject("professorList", professorDAO.findAll());

		// 데이터 담긴 모뷰 객체가 갈 곳 정해주기
		mav.setViewName("viewProfessorList.jsp");

		// 모뷰 객체 보내주기.. 안녕..
		return mav;
	}

	@RequestMapping("viewProfessor")
	@Override
	public ModelAndView viewProfessor(Long profno)
	{
		// 빈 모뷰 객체 생성
		ModelAndView mav = new ModelAndView();

		// 빈 모뷰 객체에 이름표 붙여서 데이터 집어넣기
		// 교수 한 명 정보 리스트를 받아서 넣음
		mav.addObject("professor", professorDAO.findOne(profno));

		// 데이터 담긴 모뷰 객체가 갈 곳 정해주기
		mav.setViewName("viewProfessor.jsp");

		// 모뷰 객체 보내주기.. 안녕..
		return mav;
	}

	// 모델 형이름이 모델이 아니고
	// 내가 만든 이름모델형일때는 @modelAttribute 를 이용해서 값을 넣어준다
	// 예전에 파라미터 이름랑 받는 속성이랑 다를때 requestparam사용했던거랑 비슷한것같다.

	// 전체 교수 정보 조회 껍데기 어.. 리턴값이 주소 , 리퀘스트에 몰래 담기는 객체 형은 모델
	@RequestMapping("viewModelProfessorList") // /viewProfessorList.do
	@Override
	public String viewModelProfessorList(Model model)
	{
		// 그럼 모델은 어디서 오는거지
		// dispatcherServlet이 낄 자리를 확인한 후에 ㅇㅋ하고
		// 이 메소드의 파라미터 속성값을 보고 가지고 있는 데이터를 그 속성의 형으로 변환시켜서 넣어준다
		// 빈 모델 객체 생성
		// Model model = new Model();

		// 빈 모뷰 객체에 이름표 붙여서 데이터 집어넣기
		// 교수 전체 정보 리스트를 받아서 넣음
		model.addAttribute("professorList", professorDAO.findAll());

		// 모델 객체 보내주기.. 안녕..
		return "viewModelProfessorList.jsp";
	}

}
