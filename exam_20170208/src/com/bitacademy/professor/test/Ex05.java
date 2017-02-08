package com.bitacademy.professor.test;

import com.bitacademy.professor.Professor;
import com.bitacademy.professor.ProfessorDAO;

public class Ex05{
	
	
	public static void main(String[] args)throws Exception {
		
		//2.ProfessorDAO.selectProfessor메서드를 실행한다
		//이때 조회하고자하는 학번은 9901 로 한다.
		//메서드의 리턴값은 Professor searchProfessor 변수에 저장한다.
		//3.searchProfessor를 출력해서 DB의 레코드 정보가 올바르게 출력되는 지 확인한다.
		// TB_DEPARTMENT 테이블과 조인되서 9901 번 교수의 학과정보가 올바르게 출력되나 확인
	
	Professor searchProfessor = ProfessorDAO.selectProfessor(9901L);
	System.out.println(searchProfessor);
	
	}

}
