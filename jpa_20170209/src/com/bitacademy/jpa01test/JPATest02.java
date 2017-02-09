package com.bitacademy.jpa01test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bitacademy.jpa01.Contact;
import com.bitacademy.jpa01.Office;
import com.bitacademy.jpa01.Worker;

public class JPATest02 {

	public static void main(String[] args) {
		
		// worker랑 contact여러줄이랑 조인 잘 되는 지 확인 해볼것임
		
		// 쿼리를 실행할 데이터 베이스 생성(연결?)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		
		// CRUD하는 친구 
		EntityManager em = emf.createEntityManager();
		
		// commit rollback 하는 친구
		EntityTransaction tx = em.getTransaction();
		
		// 커밋 롤백 준비
		tx.begin();
		
		// 사원 번호가 2인 사원의 전화번호 여러줄을 조회
		Worker worker= em.find(Worker.class, 2L);
		System.out.println(worker);
		
		// 커밋
		tx.commit();
		
		// 매니저친구 둘다 닫아주기
		em.close();
		emf.close();
		
	}

}
