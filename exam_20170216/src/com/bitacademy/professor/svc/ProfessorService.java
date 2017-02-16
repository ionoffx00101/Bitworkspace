package com.bitacademy.professor.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.professor.dao.ProfessorDAO;

@Controller
public class ProfessorService implements IProfessorService
{

	@Autowired // inject 쓰고싶은데 왜 안뜨지
	ProfessorDAO professorDAO;

	@RequestMapping("viewProfessorList")
	@Override
	public ModelAndView viewProfessorList()
	{
		// 빈 모뷰 객체 생성
		ModelAndView mav = new ModelAndView();

		// 빈 모뷰 객체에 이름표 붙여서 데이터 집어넣기
		// 교수 전체 정보 리스트를 받아서 넣음
		mav.addObject("professorList", professorDAO.findAll());

		// 데이터 담긴 모뷰 객체가 갈 곳 정해주기
		//mav.setViewName("viewProfessorList.jsp");

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

}
