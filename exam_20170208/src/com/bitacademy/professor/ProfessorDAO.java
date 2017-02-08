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
	 * 속성으로 저장하고있는 객체 */
	public static void insertProfessor(Professor professor) throws Exception {

		// Persistence를 통해 DB연결을 관리하는 매니저 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

		// CRUD도와주는 매니저 객체 생성
		EntityManager em = emf.createEntityManager();

		// 커밋 롤백 도와주는 트랜잭션 객체 생성
		EntityTransaction tx = em.getTransaction();

		//DB 작업 시작
		try {
			// 롤백할 곳 찍어둠
			tx.begin();

			// 메소드 파라미터 값으로 온 professor를 CRUD매니저에 넣음
			// 매니저가 다 알아서 DB에 넣어줄거임..흠
			em.merge(professor);

			// 넣었으니까 커밋해주는 매니저 호출해서 커밋ㅎ
			tx.commit();

		} catch (Exception e) {
			// 오류남 망했음 롤백해달라고 매니저한테 호출
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 오류 났든 안 났든 CRUD매니저를 종료 시켜야함
			em.close();
		}
		// DB연결 관리하는 매니저 종료 > DB연결 종료
		emf.close();

	}//end method

	/* DB에 저장된 교수정보를 수정하는 메서드
	 * 매개변수 professor
	 * -DB 에 수정하고 싶은 교수의 학번,이름,아이디,입사일,월급,성과급,직책,학과번호를
	 * 속성으로 저장하고있는 객체 */
	public static void updateProfessor(Professor professor) throws Exception {

		// Persistence를 통해 DB연결을 관리하는 매니저 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

		// CRUD도와주는 매니저 객체 생성
		EntityManager em = emf.createEntityManager();

		// 커밋 롤백 도와주는 트랜잭션 객체 생성
		EntityTransaction tx = em.getTransaction();

		//DB 작업 시작
		try {
			// 롤백할 곳 찍어둠
			tx.begin();

			// 메소드 파라미터 값으로 온 professor를 CRUD매니저에 넣음
			// 매니저가 다 알아서 DB에서 수정해줄거임 
			// 근데 나 아직 수정시키는 커맨드 모름 	
			//Query query = em.createNativeQuery("update tb_professor set where profno =" + professor.getProfno());
			//query.executeUpdate();
			em.merge(professor);

			// 변경했 커밋해주는 매니저 호출해서 커밋ㅎ
			tx.commit();

		} catch (Exception e) {
			// 오류남 망했음 롤백해달라고 매니저한테 호출
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 오류 났든 안 났든 CRUD매니저를 종료 시켜야함
			em.close();
		}
		// DB연결 관리하는 매니저 종료 > DB연결 종료
		emf.close();

	}

	/* DB에 저장된 교수정보를 삭제하는 메서드
	 * 매개변수 profno
	 * -DB 에서 삭제하려는 교수의 학번 */
	public static void deleteProfessor(Long profno) throws Exception {

		// Persistence를 통해 DB연결을 관리하는 매니저 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

		// CRUD도와주는 매니저 객체 생성
		EntityManager em = emf.createEntityManager();

		// 커밋 롤백 도와주는 트랜잭션 객체 생성
		EntityTransaction tx = em.getTransaction();

		//DB 작업 시작
		try {
			// 롤백할 곳 찍어둠
			tx.begin();

			// 메소드 파라미터 값으로 온 professor를 CRUD매니저에 넣음
			// 매니저가 다 알아서 DB에 professor와 일치하는 데이터를 삭제시켜줄거임
			// em.remove(professor); 버젼 달라지면서 안됨 ㅇ
			Query query = em.createNativeQuery("delete from tb_professor where profno =" + profno);
			query.executeUpdate();

			// 삭제했으니까 커밋해주는 매니저 호출해서 커밋ㅎ
			tx.commit();

		} catch (Exception e) {
			// 오류남 망했음 롤백해달라고 매니저한테 호출
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 오류 났든 안 났든 CRUD매니저를 종료 시켜야함
			em.close();
		}
		// DB연결 관리하는 매니저 종료 > DB연결 종료
		emf.close();

	}

	/* 전체 교수 조회 */
	public static List<Professor> selectProfessorList() throws Exception {
		
		// 교수정보들을 리스트로 담을 리스트를 미리 빈 공간으로 생성해둔다.
		List<Professor> professorList = new ArrayList<Professor>();

		// Persistence를 통해 DB연결을 관리하는 매니저 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

		// CRUD도와주는 매니저 객체 생성
		EntityManager em = emf.createEntityManager();

		// 커밋 롤백 도와주는 트랜잭션 객체 생성
		EntityTransaction tx = em.getTransaction();

		//DB 작업 시작
		try {
			// 롤백할 곳 찍어둠
			tx.begin();

			// 전체 조회 할 거임
			// tb_professor 테이블의 전체 레코드를 조회 (select p from Professor p)해서
			// 각 레코드들의 조회결과를 Professor.class의 속성에 저장하고 조회한 결과를 변수 professorList에 저장
			// 받을 List = crud매니저.쿼리만든다("select 테이블별칭 from entity연결된클래스이름 별칭",연결된클래스이름.class).리스트로 가져온다();
			professorList = em.createQuery("select g from Professor g", Professor.class).getResultList();

			// 에러없이 잘봤으니 커밋해주는 매니저 호출해서 커밋ㅎ
			tx.commit();

		} catch (Exception e) {
			// 오류남 망했음 롤백해달라고 매니저한테 호출
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 오류 났든 안 났든 CRUD매니저를 종료 시켜야함
			em.close();
		}
		// DB연결 관리하는 매니저 종료 > DB연결 종료
		emf.close();

		// 전체 교수 정보를 리턴한다
		return professorList;

	}

	/* 학번이 일치하는 교수정보를 DB에서 조회
	 * Professor 객체의 속성에 저장해서
	 * Professor 객체를 리턴
	 * 매개변수:profno 조회하려는 교수 번호 */
	public static Professor selectProfessor(Long profno) throws Exception {
		
		// 교수정보를 담을 교수껍데기를 미리 생성해둔다.
		Professor professor = null;

		// Persistence를 통해 DB연결을 관리하는 매니저 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

		// CRUD도와주는 매니저 객체 생성
		EntityManager em = emf.createEntityManager();

		// 커밋 롤백 도와주는 트랜잭션 객체 생성
		EntityTransaction tx = em.getTransaction();

		//DB 작업 시작
		try {
			// 롤백할 곳 찍어둠
			tx.begin();

			// 교수 번호를 통해서 교수 정보를 조회할거임
			// 받는다 = crud매니저.찾는다(entity연결된테이블이름.클래스,PK로 설정된 컬럼의 검색할 데이터값)
			professor = em.find(Professor.class, profno);

			// 넣었으니까 커밋해주는 매니저 호출해서 커밋ㅎ
			tx.commit();

		} catch (Exception e) {
			// 오류남 망했음 롤백해달라고 매니저한테 호출
			e.printStackTrace();
			tx.rollback();
		} finally {
			// 오류 났든 안 났든 CRUD매니저를 종료 시켜야함
			em.close();
		}
		// DB연결 관리하는 매니저 종료 > DB연결 종료
		emf.close();
		
		// 한 줄짜리 교수 정보를 리턴한다
		return professor;
		
	}

}
