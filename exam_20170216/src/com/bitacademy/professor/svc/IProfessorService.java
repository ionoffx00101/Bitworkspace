package com.bitacademy.professor.svc;

import org.springframework.web.servlet.ModelAndView;

public interface IProfessorService
{
	// 전체 교수 정보 조회 껍데기
	ModelAndView viewProfessorList();
	// 교수 1명 조회 껍데기
	// ModelAndView viewProfessor(String profno);
	ModelAndView viewProfessor(Long profno);
}
