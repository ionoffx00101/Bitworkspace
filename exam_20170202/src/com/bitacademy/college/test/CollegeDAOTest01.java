package com.bitacademy.college.test;

import java.util.ArrayList;
import com.bitacademy.college.College;
import com.bitacademy.college.CollegeDAO;

public class CollegeDAOTest01 {

	public static void main(String args[]) throws Exception {
		ArrayList<College> collegeList = null;
		College college = null;

		// CollegeDAO의 selectCollegeList()를 호출,collegeList에 저장
		collegeList = CollegeDAO.selectCollegeList();

		// collegeList변수에 저장된 단과대학의 수만큼 반복문을 실행한다
		for (int i = 0; i < collegeList.size(); i++) {

			//collegeList에서 i번째 단과대학정보를 꺼내서 변수 college에 저장
			college = collegeList.get(i);

			//변수 college를 출력
			System.out.println(college);
			// System.out.println(college.toString());
			// System.out.println(college.getColname());
			
		}

		/* 1.CollegeDAO의 selectCollegeList()를 호출해서
		 * 데이터베이스의 전체 단과대학 리스트를 조회하고
		 * 조회한 단과 대학 리스트를 변수 collegeList에 저장한다.
		 * 
		 * collegeList=CollegeDAO.selectCollegeList();
		 * 
		 * 2. collegeList변수에 저장된 단과대학의 수만큼 반복문을 실행한다
		 * collegeList변수에 저장된 단과 대학의 수는 collegeList.size() 로 알 수있다
		 * 
		 * for(int i=0;i<collegeList.size();i++){
		 * 
		 * 2.1 collegeList에서 i번째 단과대학정보를 꺼내서 변수 college에 저장한다
		 * collegeList에서 i번째 객체를 꺼내는 명령은
		 * collegeList.get(i)
		 * 
		 * college=collegeList.get(i);
		 * 
		 * 2.2 변수 college를 출력한다
		 * 
		 * System.out.println(college);
		 * 
		 * } */

	}

}
