package com.bitacademy.professor;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DeptDAO {
	/*전체 학과 조회 */
	public static List<Dept> selectDeptList() throws Exception {

		// dept를 List로 담을 List 껍데기 생성
		List<Dept> deptList = new ArrayList<Dept>();

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

			// deptList 만들기
			deptList = em.createQuery("select d from Dept d", Dept.class).getResultList();

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

		// deptlist를 리턴한다
		return deptList;

	}

}