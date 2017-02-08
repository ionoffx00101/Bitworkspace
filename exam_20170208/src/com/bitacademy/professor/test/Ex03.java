package com.bitacademy.professor.test;

import java.util.Date;

import com.bitacademy.professor.Dept;
import com.bitacademy.professor.Professor;
import com.bitacademy.professor.ProfessorDAO;

public class Ex03 {

	public static void main(String[] args) throws Exception {

		// professor 객체 생성
		Professor prof = new Professor();
		// professor에 데이터 집어넣기
		prof.profno = 7777L;
		prof.name = "성춘향";
		prof.userid = "chun";
		prof.position = "joprof";
		prof.sal = 700L;
		Date hiredate = new java.util.Date("2010/12/12");
		prof.hiredate = new java.sql.Date(hiredate.getTime());
		prof.comm = "20";
		// professor하위 속성인 dept 객체 생성
		Dept dept = new Dept();
		// dept에 데이터 넣기
		dept.deptno = 101L;
		// prof에 dept넣기
		prof.dept = dept;

		// 메소드 불러서 생성한 객체 넣기
		ProfessorDAO.updateProfessor(prof);

		//1.Professor객체를 생성한다

		//2.  1객체의 속성에 다음의 값 저장
		//-학번:7777
		//-이름:성춘향
		//-아이디:chun
		//직책:조교수
		//-월급:700

		//-성과급:20

		//-입사일:2010/12/12
		/*JPA 에서 컬럼에 날짜를 저장하기 위해서는 java.util.Date 객체에 저장하고자하는 날짜를 저장한다
		 * Date hiredate=new java.util.Date("2010/12/12");
		 * 
		 * java.util.Date에 저장된 날짜를 java.util.Date로 변환
		 * new java.sql.Date(hiredate.getTime());
		 * 해서 속성에 저장한다
		 * 
		 * p.hiredate= new java.sql.Date(hiredate.getTime()); */

		//3.Dept 객체를 생성한다
		//4.3객체의 속성에 다음의 값 저장
		//-학과번호:101
		//5.3의 객체를 1객체에 저장한다
		// 1객체.dept=3객체 

		//6.ProfessorDAO.updateProfessor메서드를 실행한다.
		//7.오라클에서  TB_Professor 테이블을 조회해서
		// 1의 이몽룡이 성춘향으로 수정 되었는지 확인

	}

}
