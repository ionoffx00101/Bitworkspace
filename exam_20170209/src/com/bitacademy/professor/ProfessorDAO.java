package com.bitacademy.professor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ProfessorDAO {
	/* 교수정보를 DB에 저장하는 메서드
	 * 매개변수 professor
	 * -DB 에 저장하고 싶은 교수의 학번,이름,아이디,입사일,월급,성과급,직책,학과번호를 
	 *  속성으로 저장하고있는 객체
	 */
	public static void insertProfessor(Professor professor)throws Exception{
		
		//1.데이터베이스 연결을 관리하는 EntityManagerFactory 객체 생성
		 EntityManagerFactory emf =  Persistence.createEntityManagerFactory("jpa");
				 
	     //2.테이블에 레코드를 추가 삭제 하는 EntityManager 객체 생성			 
	     EntityManager em = emf.createEntityManager(); 
		
		 //3.데이터 베이스 테이블에 커밋 롤백하는 EntityTransaction 객체 생성	
	     EntityTransaction tx = em.getTransaction(); 
	     
	     
	     try{
	         //4.데이터 베이스 작업 시작
	          tx.begin(); 
	         //5.매개변수 professor의 속성들을 데이터베이스 테이블에 저장
	          em.merge(professor);
	         
	          //6. 커밋 -에러없이 잘 마무리 되었을때
	            tx.commit();

	        } catch (Exception e) {
	            //7.롤백-에러가 발생했을때
	        	e.printStackTrace();
	            tx.rollback(); 
	        } finally {
	            //8.테이블에 추가,수정,삭제,조회 작업 종료
	            em.close(); 
	        }
         //데이터 베이스 연결 종료  
	        emf.close(); 
		
	}//end method
	
	
	/* DB에 저장된 교수정보를 수정하는 메서드
	 * 매개변수 professor
	 * -DB 에 수정하고 싶은 교수의 학번,이름,아이디,입사일,월급,성과급,직책,학과번호를 
	 *  속성으로 저장하고있는 객체
	 */
	public static void updateProfessor(Professor professor)throws Exception{
		//1.데이터베이스 연결을 관리하는 EntityManagerFactory 객체 생성
		 EntityManagerFactory emf =  Persistence.createEntityManagerFactory("jpa");
				 
	     //2.테이블에 레코드를 추가 삭제 하는 EntityManager 객체 생성			 
	     EntityManager em = emf.createEntityManager(); 
		
		 //3.데이터 베이스 테이블에 커밋 롤백하는 EntityTransaction 객체 생성	
	     EntityTransaction tx = em.getTransaction(); 
	     
	     
	     try{
	         //4.데이터 베이스 작업 시작
	          tx.begin(); 
	         //5.PK 가 일치하는 레코드를 찾아서 매개변수 professor의 속성들을 데이터베이스 테이블에 수정
	          em.merge(professor);
	         
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
		
	
	}
	/* DB에 저장된 교수정보를 삭제하는 메서드
	 * 매개변수 profno
	 * -DB 에서 삭제하려는 교수의 학번
	 */
	public static void deleteProfessor(Long profno)throws Exception{
		//1.데이터베이스 연결을 관리하는 EntityManagerFactory 객체 생성
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
				 
	     //2.테이블에 레코드를 추가 삭제 하는 EntityManager 객체 생성			 
	     EntityManager em = emf.createEntityManager(); 
		
		 //3.데이터 베이스 테이블에 커밋 롤백하는 EntityTransaction 객체 생성	
	     EntityTransaction tx = em.getTransaction(); 
	     
	     try{
	         //4.데이터 베이스 작업 시작
	          tx.begin(); 
	         //5.매개변수 profno와 PK 가 일치하는 레코드 삭제
	          Query query =
	        		  em.createNativeQuery(
	        				  "Delete from TB_PROFESSOR where profno ="+profno);
	          query.executeUpdate();
	          //6. 커밋 -에러없이 잘 마무리 되었을때
	            tx.commit();

	        } catch (Exception e) {
	            //7.롤백-에러가 발생했을때
	        	e.printStackTrace();
	            tx.rollback(); 
	        } finally {
	            //8.테이블에 추가,수정,삭제,조회 작업 종료
	            em.close(); 
	        }
         //데이터 베이스 연결 종료  
	        emf.close(); 
		
	}

	/*
	전체 교수 조회
	 */
	public static List<Professor> selectProfessorList()throws Exception{
		List<Professor>professorList=
				new ArrayList<Professor>();
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
	         //5.tb_professor 테이블의 전체 레코드를 조회 (select p from Professor p)해서 
	         // 각 레코드들의 조회결과를 Professor.class의 속성에 저장하고 
	         // 조회한 결과를 변수 professorList에 저장	
	          professorList = em.createQuery("select g from Professor g", Professor.class).getResultList();
	         
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
		
		return professorList;//전체 물건 정보 리턴
		
  }

	
	/*
	 * 학번이 일치하는 교수정보를 DB에서 조회
	 * Professor 객체의 속성에 저장해서 
	 * Professor 객체를 리턴
	 * 매개변수:profno 조회하려는 교수 번호
	 */
	public static Professor selectProfessor(Long profno)throws Exception{
		Professor professor=null;	
		
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
	         //5.테이블의 primary key 인 profno이 일치하는 레코드를 조회해서
	         // 조회결과를 Professor 객체에 담아서 리턴받은후  변수 professor에 저장
	          professor = em.find(Professor.class, profno);
	         
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
		
		return professor;//교수 정보 리턴
		
  }
 
}

