package com.bitacademy.jpa01test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bitacademy.jpa01.Contact;
import com.bitacademy.jpa01.Office;

public class JPATest01 {

	public static void main(String[] args) {
		
		// 특정 데이터 조회할거임
		
		// 쿼리를 실행할 데이터 베이스 생성(연결?)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		
		// CRUD하는 친구 
		EntityManager em = emf.createEntityManager();
		
		// commit rollback 하는 친구
		EntityTransaction tx = em.getTransaction();
		
		// 커밋 롤백 준비
		tx.begin();
		
		// Contact 랑 worker랑 조인 되는 지 확인해볼거임
		Contact contact = em.find(Contact.class, 100L);
		System.out.println(contact);
		
		
		// 커밋
		tx.commit();
		
		// 매니저친구 둘다 닫아주기
		em.close();
		emf.close();
		
	}

}
