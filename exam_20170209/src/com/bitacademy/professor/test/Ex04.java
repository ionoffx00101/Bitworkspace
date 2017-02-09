package com.bitacademy.professor.test;

import java.util.Date;

import com.bitacademy.professor.Dept;
import com.bitacademy.professor.Professor;
import com.bitacademy.professor.ProfessorDAO;

public class Ex04 {
	
	
	public static void main(String[] args)throws Exception {
		
	
		//2.ProfessorDAO. deleteProfessor메서드를 실행한다.
		//이때 삭제하고자하는 학번은 7777로 한다.

		ProfessorDAO.deleteProfessor(7777L);
		//3.오라클을 실행시키고 TB_PROFESSOR 테이블을 조회해서
		// 1의 학번 7777인 레코드가 삭제되었는가 확인
	}

}
