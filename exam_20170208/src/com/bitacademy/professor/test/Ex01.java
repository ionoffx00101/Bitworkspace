package com.bitacademy.professor.test;

import java.util.List;

import com.bitacademy.professor.Dept;
import com.bitacademy.professor.DeptDAO;

public class Ex01 {
	
	
	public static void main(String[] args) throws Exception{
		//2.DeptDAO의 selectDeptList메서드를 실행한다
		//메서드의 리턴값은 List<Dept>deptList 변수에 저장한다.
		//3.for(int i=0;i<deptList.size();i++){
		// 3.1 deptList에 저장된 학과 객체중 i번째 객체 리턴해서 Dept타입 변수에 저장
		//    - deptList.get(i)
		// 3.2  3.1변수.toString() 을 출력한다.
		//}
		//4.전체 학과 정보가 출력되는지 확인한다.
		
		List<Dept> deptList = DeptDAO.selectDeptList();
		
		for (int i = 0; i < deptList.size(); i++) {
			Dept dept = deptList.get(i);
			System.out.println(dept);
		}
	}
}
