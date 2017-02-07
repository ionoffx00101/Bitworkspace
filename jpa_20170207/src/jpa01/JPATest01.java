package jpa01;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa_20170207.Member;

public class JPATest01 {

	public static void main(String[] args) {
		
		// Insert 할 거임
		
		// 쿼리를 실행할 데이터 베이스 생성(연결?)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		// CRUD하는 친구 
		EntityManager em = emf.createEntityManager();
		// commit rollback 하는 친구
		EntityTransaction tx = em.getTransaction();
		
		// 커밋 롤백 준비
		tx.begin();
		
		// 데이터를 저장할 멤버 객체 생성
		Member member = new Member();
		member.num= 3L; // Long 자료형이라서..L..
		member.name = "TOMATO";
		member.age = 26;
		
		// em에 데이터가 저장된 멤버 객체 넣어주기
		em.merge(member);
		
		// 커밋
		tx.commit();
		
		// 매니저친구 둘다 닫아주기
		em.close();
		emf.close();
		
	}

}
