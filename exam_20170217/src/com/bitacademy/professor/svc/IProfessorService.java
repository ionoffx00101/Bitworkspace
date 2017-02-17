package com.bitacademy.professor.svc;

import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.professor.vo.Professor;

public interface IProfessorService
{
	ModelAndView viewProfessorList(); // 교수전체조회
	ModelAndView viewProfessor(Long profno); // 교수 한 명 조회
	ModelAndView addProfessorForm(); // 교수 추가 화면으로 이동
	ModelAndView addProfessor(Professor professor); // 교수 추가
}
