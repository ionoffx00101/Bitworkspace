package com.bitacademy.good.test;

import com.bitacademy.good.Good;
import com.bitacademy.good.GoodDAO;

public class GoodDAOTest01 {

	public static void main(String[] args) throws Exception{
		/*
		 *
		 * 1.GoodDAO.selectGood(1L) 을 호출해서 물건번호가 1번일 물건정보를 조회하고
		 * 조회한 물건 정보를 Good 객체에 저장
		 * 
		 * Good good=GoodDAO.selectGood(1L);
		 * 
		 * 2.1에서 조회한 물건 정보 출력
		 * 
		 * System.out.println("물건 번호 1번 물건 정보:"+good);
		 * 
		 * 물건번호 1번인 good_seq.nextval,'갤럭시A','<p>제조사:삼성</p><p>색상:검정</p>',300000,'phone01.png'
		 * 가 출력되나 확인
		 */
		// Good 객체에 나온값 담아주기
		
		Good good = GoodDAO.selectGood(1L);
		System.out.println(good);
		
	}

}
