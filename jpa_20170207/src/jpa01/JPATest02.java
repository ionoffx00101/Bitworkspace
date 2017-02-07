package jpa01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa_20170207.Member;

public class JPATest02 {

	public static void main(String[] args) {
		
		// 특정 데이터(학번) 조회할거임
		
		// 쿼리를 실행할 데이터 베이스 생성(연결?)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		// CRUD하는 친구 
		EntityManager em = emf.createEntityManager();
		// commit rollback 하는 친구
		EntityTransaction tx = em.getTransaction();
		
		// 커밋 롤백 준비
		tx.begin();
		
		// tb_member 테이블에서 PK(num) 이 1인 레코드 조회 
		
		// 조회 결과를 Member.Class에 담아서 리턴
		// 멤버클래스 변수이름 = em.찾다(멤버클래스를 사용한다,PK가 1L인 걸 찾는다)
		Member selectMember = em.find(Member.class, 1L);
		System.out.println(selectMember);
		
		// 커밋
		tx.commit();
		
		// 매니저친구 둘다 닫아주기
		em.close();
		emf.close();
		
	}

}
