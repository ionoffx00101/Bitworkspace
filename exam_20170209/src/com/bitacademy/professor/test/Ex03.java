package com.bitacademy.professor.test;

import java.util.Date;

import com.bitacademy.professor.Dept;
import com.bitacademy.professor.Professor;
import com.bitacademy.professor.ProfessorDAO;

public class Ex03 {
	
	public static void main(String[] args)throws Exception{
		//1.Professor객체를 생성한다
		Professor professor = new Professor();
		//2.  1객체의 속성에 다음의 값 저장
		//-학번:7777
		//-이름:성춘향
		//-아이디:chun
		//직책:조교수
		//-월급:700
		
		//-성과급:20
		
		//-입사일:2010/12/12
		/*
		JPA 에서 컬럼에 날짜를 저장하기 위해서는 java.util.Date 객체에 저장하고자하는 날짜를 저장한다
		Date hiredate=new java.util.Date("2010/12/12");
		
		java.util.Date에 저장된 날짜를 java.sql.Date로 변환
	        new java.sql.Date(hiredate.getTime());
	     해서 속성에 저장한다
	     
	        p.hiredate= new java.sql.Date(hiredate.getTime());
		*/
		professor.profno = 7777L;
		professor.name = "성춘향";
		professor.userid = "chun";
		professor.position = "조교수";
		professor.sal = 700L;
		
		Date hiredate = new java.util.Date("2010/12/12");
		professor.hiredate = new java.sql.Date(hiredate.getTime());
		
		professor.comm = "20";
		
		//3.Dept 객체를 생성한다
		Dept dept = new Dept();
		//4.3객체의 속성에 다음의 값 저장
		//-학과번호:101
		dept.deptno = 101L;
		//5.3의 객체를 1객체에 저장한다
		 // 1객체.dept=3객체 
		professor.dept = dept;
		//6.ProfessorDAO.updateProfessor메서드를 실행한다.
		ProfessorDAO.updateProfessor(professor);
		//7.오라클에서  TB_Professor 테이블을 조회해서
		// 1의 이몽룡이 성춘향으로 수정 되었는지 확인

	}

}
