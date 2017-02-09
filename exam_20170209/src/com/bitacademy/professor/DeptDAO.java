package com.bitacademy.professor;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeptDAO {
	/*
	전체 학과 조회
	 */
	public static List<Dept> selectDeptList()throws Exception{
		List<Dept>deptList=new ArrayList<Dept>();
		//1.데이터베이스 연결을 관리하는 EntityManagerFactory 객체 생성
		 EntityManagerFactory emf = 
				 Persistence.createEntityManagerFactory("jpa");
				 
	     //2.테이블에 레코드를 추가 삭제 하는 EntityManager 객체 생성			 
	     EntityManager em = emf.createEntityManager(); 
		
		 //3.데이터 베이스 테이블에 커밋 롤백하는 EntityTransaction 객체 생성	
	     EntityTransaction tx = em.getTransaction(); 
	     
	     
	     try{
	         //4.데이터 베이스 작업 시작
	          tx.begin(); 
	         //5.tb_dept 테이블의 전체 레코드를 조회 (select p from Dept p)해서 
	         //	각 레코드들의 조회결과를 Dept.class의 속성에 저장하고 
	         //	조회한 결과를 변수 deptList에 저장	
	          deptList = 
	        		  em.createQuery(
	        				  "select g from Dept g", Dept.class).getResultList();
	         
	          //6. 커밋 -에러없이 잘 마무리 되었을때
	            tx.commit();

	        } catch (Exception e) {
	            //7.롤백-에러가 발생했을때
	            tx.rollback(); 
	        } finally {
	            //8.테이블에 추가,수정,삭제,조회 작업 종료
	            em.close(); 
	        }
           //데이터 베이스 연결 종료  
	        emf.close(); 
		
		
		
		return deptList;//전체 학과 정보 리턴
  }

}