package com.bitacademy.mall.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.good.Good;
import com.bitacademy.good.GoodDAO;


public class Ex01 {

	public static void main(String[] args) {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext(
						"dispatcher-servlet.xml");
		/*
		 1.공유 영역에서 GoodDAO 객체를 꺼내서 변수에 저장
		 2.전체 물건 조회 메서드 
		  1객체의 findAll() 메서드를 호출하고 결과를 출력
		 -jpa_20170213 프로젝트의 ApplicationContextTest 참조 
		 * */
		
		GoodDAO gooddao = (GoodDAO) ctx.getBean("goodDAO");  // object형으로 나와서 형변환을 해줘야한다
		List<Good> goodList = gooddao.findAll();
		
		for (int i = 0; i < goodList.size(); i++) {
			Good good = goodList.get(i);
			System.out.println(good);
		}

	}

}
