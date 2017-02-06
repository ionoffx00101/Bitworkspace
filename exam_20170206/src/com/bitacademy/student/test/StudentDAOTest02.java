package com.bitacademy.student.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.bitacademy.student.Student;
import com.bitacademy.student.StudentDAO;


public class StudentDAOTest02 {

	
	public static void main(String args[]) throws Exception{
		Student student=null;
		
		/*
		 *  1.StudentDAO의 selectStudent("guest")를 호출해서
		 *  아이디가 "guest" 인 학생의 정보를 데이터 베이스에서 조회해서 변수 student에 저장
		 *  student=StudentDAO.selectStudent("guest");
		 */
		student = StudentDAO.selectStudent("guest");
		 /*  2.변수 student 를 출력
		 *  System.out.println("아이디가 guest인 학생 정보:"+student);
		 *  
		 *  이름 홍길동, 아이디 guest, 비밀번호 1234  학과 번호 101 학과명 컴퓨터 공학과 학과위치 1호관
		 *  이 데이터베이스에서 조회되서 출력되는지 확인
		 */
		System.out.println("아이디가 guest인 학생 정보 : " + student);
		 /*   
		 *  3.StudentDAO의 selectStudent("aroma")를 호출해서
		 *  아이디가 "aroma" 인 학생의 정보를 데이터 베이스에서 조회해서 변수 student에 저장
		 *  student=StudentDAO.selectStudent("aroma");
		 */
		student = StudentDAO.selectStudent("aroma");
		 /*  
		 *  4.변수 student 를 출력
		 *  System.out.println("아이디가 aroma인 학생 정보:"+student);
		 */  
		 /*  아이디가 aroma인 학생은 데이터베이스에 존재 하지 않으므로 null 이 출력되나 확인
		 * */
		System.out.println("아이디가 aroma인 학생 정보 : " + student);
	}
}
