package com.bitacademy.good;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GoodDAO {

	/* 번호가이 일치하는 물건정보를 DB에서 조회
	 * Good 객체의 속성에 저장해서
	 * Good 객체를 리턴
	 * 매개변수:gnum 조회하려는 물건 번호 */
	public static Good selectGood(Long gnum) throws Exception {
		
		// Good 객체 생성
		Good good = null;

		// DB연결해주는 객체생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		// CRUD해주는 매니저 객체생성
		EntityManager em = emf.createEntityManager();
		// 커밋 롤백해주는 트랜잭션 객체 생성
		EntityTransaction tx = em.getTransaction();

		// 데이터 베이스 작업 시작
		try {
			// 커밋 롤백 준비
			tx.begin();

			// select * from Good where gnum = ? 문장을 만드는 것이다	    	 
			// 5.테이블의 primary key 인 gnum이 일치하는 레코드를 조회해서
			// 조회결과를 Good 객체에 담아서 리턴받은후  변수 good에 저장
			good = em.find(Good.class, gnum);
			
			//6. 커밋 -에러없이 잘 마무리 되었을때
			tx.commit();

		} catch (Exception e) {
			// 오류가 발생했으니 롤백을 해달라고 하자
			tx.rollback();
		} finally {
			// 오류가 나든 안 나든 끝났으니 CRUD매니저들을 종료시키자
			em.close();

		}
		// 데이터 베이스도 연결 종료
		emf.close();

		//물건 정보 리턴
		return good;
	}

	// 전체 물건 조회
	public static List<Good> selectGoodList() throws Exception {
		// 굿리스트 미리 생성?
		List<Good> goodList = new ArrayList<Good>();

		//1.데이터베이스 연결을 관리하는 EntityManagerFactory 객체 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

		//2.테이블에 레코드를 추가 삭제 하는 EntityManager 객체 생성			 
		EntityManager em = emf.createEntityManager();

		//3.데이터 베이스 테이블에 커밋 롤백하는 EntityTransaction 객체 생성	
		EntityTransaction tx = em.getTransaction();

		try {
			//4.데이터 베이스 작업 시작
			tx.begin();

			// select * from good
			// 5.tb_good 테이블의 전체 레코드를 조회 (select g from Good g)해서 각 레코드들의 조회결과를 Good.class의 속성에 저장하고 조회한 결과를 변수 goodList에 저장	
			goodList = em.createQuery("select g from Good g", Good.class).getResultList();

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

		return goodList;//전체 물건 정보 리턴
	}

	/* 물건정보를 DB에 저장하는 메서드
	 * 매개변수 good
	 * -DB 에 저장하고 싶은 물건의 이름,가격,설명,이미지파일이름를
	 * 속성으로 저장하고있는 객체 */
	public static void insertGood(Good good) throws Exception {
		//1.데이터베이스 연결을 관리하는 EntityManagerFactory 객체 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

		//2.테이블에 레코드를 추가 삭제 하는 EntityManager 객체 생성			 
		EntityManager em = emf.createEntityManager();

		//3.데이터 베이스 테이블에 커밋 롤백하는 EntityTransaction 객체 생성	
		EntityTransaction tx = em.getTransaction();

		try {
			//4.데이터 베이스 작업 시작
			tx.begin();

			//5.매개변수 good의 속성들을 데이터베이스 테이블에 저장
			em.merge(good);

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

	}//end method

}