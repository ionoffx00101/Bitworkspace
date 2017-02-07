package com.bitacademy.good.test;

import java.util.List;

import com.bitacademy.good.Good;
import com.bitacademy.good.GoodDAO;

public class GoodDAOTest02 {

	public static void main(String[] args) throws Exception{
		/*
		 *
		 * 1.GoodDAO.selectGoodList() 을 호출해서 tb_good 테이블의 전체 물건 정보를 조회하고
		 * 조회한 물건 정보를 ArrayList<Good>goodList 에 저장
		 * 
		 * List<Good>goodList=GoodDAO.selectGoodList();
		 * 
		 * 2.1에서 조회한 전체 물건 정보 출력
		 * 
		 * System.out.println("전체 물건 정보:"+goodList);
		 * 
		 * tb_good 테이블의 전체 물건정보가 출력되는지 확인
		 */
		
		List<Good>goodList=GoodDAO.selectGoodList();
		System.out.println("전체 물건 정보:"+goodList);
	}

}
