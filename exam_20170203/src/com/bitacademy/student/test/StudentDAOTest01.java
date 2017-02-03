package com.bitacademy.student.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.bitacademy.dept.Dept;
import com.bitacademy.student.Student;
import com.bitacademy.student.StudentDAO;


public class StudentDAOTest01 {

	
	public static void main(String args[]) throws Exception{
		/*
		 * 1.Student 객체 생성 
		 * Student student=new Student();
		 * 
		 * 2. 1객체 속성에 다음의 값대입
		 * -학번:"7788"
		   -이름:"홍길순"
	       -userid:"Dals"
	       -pw:"1234"
		 */
		
		//3.Dept 객체를 생성한다
		//  Dept dept=new Dept();
		
		//4. 3객체 속성에 다음의 값 대입
		//-학과번호:101
		//  dept.deptno="101";
		
		//5.3의 객체를 1객체에 저장한다
	    // 1객체.dept=3객체; 
		

		//6.StudentDAO.insertStudent(1객체)메서드를 실행한다.
		//7.오라클에서  TB_Stu 테이블을 조회해서
		// 1의 홍길순 이 테이블에 추가되었는가 확인
		Student student = new Student();
		
		student.studno = "7788";
		student.name = "홍길순";
		student.userid = "Dals";
		student.pw = "1234";
		
		Dept dept = new Dept();
		dept.setDeptno("101");
		//객체의 변수가 null값이면 호출하지 못함
		//student.dept.setDeptno("101") -> 에러
		
		student.dept = dept;
		
		StudentDAO.insertStudent(student);
		
	}

}
