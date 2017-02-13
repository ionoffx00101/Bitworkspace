package com.bitacademy.mall.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.buy.Buy;
import com.bitacademy.buy.BuyDAO;


public class Ex04 {

	public static void main(String[] args) {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext(
						"dispatcher-servlet.xml");
		/*
		 1.공유 영역에서 BuyDAO 객체를 꺼내서 변수에 저장
		 2.1객체의 selectCustomerBuyList("aroma")
		  를 호출해서 회원 아이디 aroma가 구매한 물건리스트를 출력
		  
		 jpa_20170213 프로젝트의 ApplicationContextTest 참조  
		
		  
		 * */
		
		BuyDAO buydao = (BuyDAO)ctx.getBean("buyDAO");
		
		String name ="aroma";
		List<Buy> buyList = buydao.selectCustomerBuyList(name);
		
		for (int i = 0; i < buyList.size(); i++) {
			Buy buy = buyList.get(i);
			System.out.println(buy);
		}
		
	}

}
