package com.bitacademy.good.test;

import com.bitacademy.good.Good;
import com.bitacademy.good.GoodDAO;

public class GoodDAOTest03 {

	public static void main(String[] args) throws Exception{
		/*
		 *
		 * 1.Good 객체 생성
		 * Good good=new Good();
		 */
		
		//2. 물건이름 속성(name)에 갤럭시 S7 대입
		//good.name="갤럭시 S7";
		
		//3.물건 설명 속성(detail) 에 "휴대시 폭발 주의" 대입
		//good.detail="휴대시 폭발 주의";
		
		//4.물건 이미지 파일명 속성(img)에 "phone07.png" 대입
		//good.img="phone07.png";
		
		//5.물건 가격 속성(price) 에 900000 대입
		//good.price=900000;
		
		//6.GoodDAO.insertGood(good) 메서드 호출
		
		//7.데이터 베이스 tb_good 테이블에 "갤럭시 S7" "휴대시 폭발주의" "phone07.png" 900000 
		//가 저장되었는지 확인
		
		// 데이터 생성
		Good good=new Good();
		good.name="갤럭시 S7";
		good.detail="휴대시 폭발 주의";
		good.img="phone07.png";
		good.price=900000;
		
		// 저장
		GoodDAO.insertGood(good);
		
	}

}
