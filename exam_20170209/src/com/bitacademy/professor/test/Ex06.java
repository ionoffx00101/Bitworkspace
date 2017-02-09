package com.bitacademy.professor.test;

import java.util.ArrayList;
import java.util.List;

import com.bitacademy.professor.Professor;
import com.bitacademy.professor.ProfessorDAO;

public class Ex06 {
	
	
	public static void main(String[] args) throws Exception{
		List<Professor> professorList = new ArrayList<Professor>();
		//2.ProfessorDAO의 selectProfessorList메서드를 실행한다
		//메서드의 리턴값은 List<Professor>professorList 변수에 저장한다.
		professorList = ProfessorDAO.selectProfessorList();
		//3.for(int i=0;i<professorList.size();i++){
		// 3.1 professorList에 저장된 교수 객체중 i번째 객체 리턴해서 변수에 저장
		//    - professorList.get(i)
		// 3.2  3.1변수.toString() 을 출력한다.
		//}
		for(Professor p : professorList){
			System.out.println(p);
		}
		//4.전체 교수 정보가 출력되는지 확인한다.
		// TB_DEPARTMENT 테이블과 조인되서  교수의 학과정보가 올바르게 출력되나 확인
	}
}
