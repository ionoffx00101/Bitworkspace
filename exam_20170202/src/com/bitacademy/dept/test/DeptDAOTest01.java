package com.bitacademy.dept.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import com.bitacademy.dept.Dept;
import com.bitacademy.dept.DeptDAO;

public class DeptDAOTest01 {

	
	public static void main(String args[]) throws Exception{
		
		ArrayList<Dept>deptList=null;
		Dept dept=null;
		
		// selectDeptList 메서드 static으로 바꾸어줌
		deptList = DeptDAO.selectDeptList("100");
		
		for (int i = 0; i < deptList.size(); i++) {
			// dept에 i번째 정보 담기
			dept = deptList.get(i);
			// dept출력
			System.out.println(dept);
		}
		
		/*
		 *  1.DeptDAO의 selectDeptList("100")를 호출해서
		 *  데이터베이스의 100번 단과대학에 소속된 전체 학과 리스트를 조회하고 
		 *  조회한 단과 대학 리스트를 변수 deptList에 저장한다.
		 *   
		 *   deptList=DeptDAO.selectDeptList("100");
		 *   
		 *  2. deptList변수에 저장된 학과의 수만큼 반복문을 실행한다
		 *  deptList변수에 저장된 단과 대학의 수는 deptList.size() 로 알 수있다
		 *  
		 *   for(int i=0;i<deptList.size();i++){
		 *      
		 *      2.1 deptList에서 i번째 학과정보를 꺼내서 변수 dept에 저장한다
		 *          deptList에서 i번째 객체를 꺼내는 명령은
		 *          deptList.get(i)    
		 *     
		 *      dept=deptList.get(i);
		 *      
		 *      2.2 변수 dept를 출력한다
		 *      
		 *      System.out.println(dept);
		 *   
		 *   }
		 * */
	}

}
