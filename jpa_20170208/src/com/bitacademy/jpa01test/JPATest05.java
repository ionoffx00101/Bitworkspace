package com.bitacademy.jpa01test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bitacademy.jpa01.Contact;

public class JPATest05 {

	public static void main(String[] args) {
		
		// 조인을 써서 contact,worker 둘다 조회할 것이다
		
		// 쿼리를 실행할 데이터 베이스 생성(연결?)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		
		// CRUD하는 친구 
		EntityManager em = emf.createEntityManager();
		
		// commit rollback 하는 친구
		EntityTransaction tx = em.getTransaction();
		
		// 커밋 롤백 준비
		tx.begin();
		
		// 전화번호 인덱스 번호가 100인걸 검색
		Contact contact = em.find(Contact.class, 100L);
		
		// 그냥 알아서 조인해서 보여주네 개꿀;;
		System.out.println(contact);
		
		// 커밋
		tx.commit();
		
		// 매니저친구 둘다 닫아주기
		em.close();
		emf.close();
		
	}

}
