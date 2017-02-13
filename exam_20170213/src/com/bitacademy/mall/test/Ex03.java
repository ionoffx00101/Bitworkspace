package com.bitacademy.mall.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.good.Good;
import com.bitacademy.good.GoodDAO;


public class Ex03 {

	public static void main(String[] args) {
		ApplicationContext ctx=
				new ClassPathXmlApplicationContext(
						"dispatcher-servlet.xml");
		/*
		 1.공유 영역에서 GoodDAO 객체를 꺼내서 변수에 저장
		 2.Good 객체 생성
		 3. 2의 객체의 속성에 데이터 베이스에 저장하고 싶은 물건정보 대입
		 4. 1의 객체에서 데이터베이스에 레코드를 저장하는
		   save(2객체) 메서드 호출
		 * */
		
		GoodDAO gooddao = (GoodDAO)ctx.getBean("goodDAO");
		
		Good good = new Good();
		good.gnum=59L;
		good.name="갤럭시 노트59";
		good.price=590000L;
		good.detail="안터짐";
		
		gooddao.save(good);
		
		

	}

}
