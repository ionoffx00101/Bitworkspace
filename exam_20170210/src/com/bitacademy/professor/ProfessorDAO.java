package com.bitacademy.professor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

/*
1.Exception 발생시 롤백 하도록 설정
@Transactional(
		rollbackFor={Throwable.class})
*/
@Transactional(rollbackFor={Throwable.class}) // 모든 익셉션시 롤백함
public class ProfessorDAO {
	/*
	 * 1.EntityManager 객체를 스프링이 생성해서 
	 * 대입하고
	 * 스프링에서 자동으로 롤백, 커밋, 데이터베이스 연결 종료하도록
	 * @PersistenceContext
	 * 어노테이션 추가
	 * */
	@PersistenceContext 
	EntityManager em;
	
	/* 교수정보를 DB에 저장하는 메서드
	 * 매개변수 professor
	 * -DB 에 저장하고 싶은 교수의 학번,이름,아이디,입사일,월급,성과급,직책,학과번호를 
	 *  속성으로 저장하고있는 객체
	 */
	public  void insertProfessor(Professor professor)throws Exception{
         //2.매개변수 professor의 속성들을 데이터베이스 테이블에 저장
          //em.merge(professor);
		// 사용자가 보낸 정보가 서비스를 통해 이곳에 도착했다. 이제 여기서 em의 도움을 받아 데이터 베이스에 보내 저장한다.
		em.merge(professor);
	}//end method
	
	
	/* DB에 저장된 교수정보를 수정하는 메서드
	 * 매개변수 professor
	 * -DB 에 수정하고 싶은 교수의 학번,이름,아이디,입사일,월급,성과급,직책,학과번호를 
	 *  속성으로 저장하고있는 객체
	 */
	public  void updateProfessor(Professor professor)throws Exception{

     //3.PK 가 일치하는 레코드를 찾아서 매개변수 professor의 속성들을 데이터베이스 테이블에 수정
      //em.merge(professor);
		em.merge(professor);
		//덮어쓰기?
   
	}
	/* DB에 저장된 교수정보를 삭제하는 메서드
	 * 매개변수 profno
	 * -DB 에서 삭제하려는 교수의 학번
	 */
	public  void deleteProfessor(Long profno)throws Exception{
     //4.매개변수 profno와 PK 가 일치하는 레코드 삭제하는 쿼리 생성
     /* Query query =
    		  em.createNativeQuery(
    				  "Delete from TB_PROFESSOR where profno ="+profno);
     */
		//5.4의 쿼리 실행
        //query.executeUpdate();
		Query query = em.createNativeQuery("Delete from TB_PROFESSOR where profno="+profno);
		// 쿼리 쿼리변수이름 = entity매니저.만든다현지어쿼리("삭제하는 쿼리문 oracle에서 쓰이는 거랑 똑같이 쓴다");
		
		query.executeUpdate();
      }

	/*
	전체 교수 조회
	 */
	public  List<Professor> selectProfessorList()throws Exception{
		
	     //5.tb_professor 테이블의 전체 레코드를 조회 (select p from Professor p)해서 
	     // 각 레코드들의 조회결과를 Professor.class의 속성에 저장하고 
	     // 조회한 결과를 변수 professorList에 저장	
	     // professorList = em.createQuery("select g from Professor g", Professor.class).getResultList();
		
		// 비어있는 프로페서기반의 리스트 객체를 만들어둔다
		List<Professor>professorList=null;
		// em의 도움을 받아서 professor의 전체 리스트를 조회하고 그걸 비어있는 professor 리스트에 넣는다
		professorList = em.createQuery("select g from Professor g",Professor.class).getResultList();
	    //받아주는 리스트 = entitymanager객체.쿼리만든다("select 테이블 별칭 from entity연결된 클래스 별칭",Entity연결된클래스.class).가져온다결과리스트;
		
		return professorList;//전체 물건 정보 리턴
		
  }

	
	/*
	 * 학번이 일치하는 교수정보를 DB에서 조회
	 * Professor 객체의 속성에 저장해서 
	 * Professor 객체를 리턴
	 * 매개변수:profno 조회하려는 교수 번호
	 */
	public  Professor selectProfessor(Long profno)throws Exception{
		
	 //6.테이블의 primary key 인 profno이 일치하는 레코드를 조회해서
     // 조회결과를 Professor 객체에 담아서 리턴받은후  변수 professor에 저장
      //professor = em.find(Professor.class, profno);
		
		// 학번 받아서 교수 한명 조회
		Professor professor=null;	
		
		professor = em.find(Professor.class, profno);
		return professor;//교수 정보 리턴
		
  }
 
}

