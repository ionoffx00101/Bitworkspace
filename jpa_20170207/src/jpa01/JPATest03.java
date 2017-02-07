package jpa01;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import jpa_20170207.Member;

public class JPATest03 {

	public static void main(String[] args) {

		// 전체 데이터 조회할거임

		// 쿼리를 실행할 데이터 베이스 생성(연결?)
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");
		// CRUD하는 친구 
		EntityManager em = emf.createEntityManager();
		// commit rollback 하는 친구
		EntityTransaction tx = em.getTransaction();

		// 커밋 롤백 준비
		tx.begin();

		// 리스트 타입으로 바꿔주기
		// em.createQuery("select m from Member m", Member.class).getResultList()
		// em.만들다 쿼리("select 테이블별칭하나만 적어라 알아서 해준다 from Entity붙인 클래스 별칭",도와줄 JPA코딩된 클래스).리스트로 변환시켜줘.. 
		List<Member> memberList = em.createQuery("select m from Member m", Member.class).getResultList();

		// 꺼내서 본다
		for (int i = 0; i < memberList.size(); i++) {
			// 한줄만 꺼내서 Member에 넣는다
			Member member = memberList.get(i);
			System.out.println(member);
		}
		
		// 커밋
		tx.commit();

		// 매니저친구 둘다 닫아주기
		em.close();
		emf.close();

	}

}
