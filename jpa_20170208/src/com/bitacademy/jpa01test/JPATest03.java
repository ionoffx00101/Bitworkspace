package com.bitacademy.jpa01test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.bitacademy.jpa01.Office;

public class JPATest03 {

	public static void main(String[] args) {
		
		// 컬럼값에 널이 있는 데이터 넣을거임
		
		// 쿼리를 실행할 데이터 베이스 생성(연결?)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		
		// CRUD하는 친구 
		EntityManager em = emf.createEntityManager();
		
		// commit rollback 하는 친구
		EntityTransaction tx = em.getTransaction();
		
		// 커밋 롤백 준비
		tx.begin();
		
		// Office 생성해서 데이터 집어넣기
		Office office1 = new Office();
		office1.officenum=-200L;
		office1.officename="우으";
		//office1.address=null;
		office1.officephone="02-1394-9930";
		
		// em매니저에 데이터가 담긴 Office넣기
		em.merge(office1);
		
		// 커밋
		tx.commit();
		
		// 매니저친구 둘다 닫아주기
		em.close();
		emf.close();
		
	}

}
