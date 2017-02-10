package com.bitacademy.professor;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/*1.Exception 발생시 롤백 하도록 설정
 * 
 * @Transactional(
 * rollbackFor={Throwable.class}) */
@Transactional(rollbackFor={Throwable.class})
public class DeptDAO {
	/* 1.EntityManager 객체를 스프링이 생성해서
	 * 대입하고
	 * 스프링에서 자동으로 롤백, 커밋, 데이터베이스 연결 종료하도록
	 * 
	 * @PersistenceContext
	 * 어노테이션 추가 */
	@PersistenceContext
	EntityManager em;

	/*전체 학과 조회 */
	public List<Dept> selectDeptList() throws Exception {

		//2.tb_dept 테이블의 전체 레코드를 조회 (select p from Dept p)해서 
		//	각 레코드들의 조회결과를 Dept.class의 속성에 저장하고 
		//	조회한 결과를 변수 deptList에 저장	
		/*deptList =
		 * em.createQuery(
		 * "select g from Dept g", Dept.class).getResultList(); */
		List<Dept> deptList = null;

		deptList = em.createQuery("select g from Dept g", Dept.class).getResultList();

		return deptList;//전체 학과 정보 리턴
	}

}