package com.bitacademy.mall.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.buy.Buy;
import com.bitacademy.buy.BuyDAO;
import com.bitacademy.good.Good;
import com.bitacademy.good.GoodDAO;

public class Ex02 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		/*1.공유 영역에서 GoodDAO 객체를 꺼내서 변수에 저장
		 * 2.전체 1개 조회 메서드
		 * 1객체의 getOne(조회하고자하는 물건 번호 -데이터베이스 테이블에서 확인)
		 * 메서드를 호출하고 결과를 출력
		 * -강사컴퓨터 jpa_20170213 프로젝트 AccountService 의 115번째줄 참조
		 * -jpa_20170213 프로젝트의 ApplicationContextTest 참조 */

		//  org.hibernate.LazyInitializationException: could not initialize proxy - no Session
		// 상속을 잘 못 준것같다.
		// getone()에 1을 넣어도 pk컬럼중 1인걸 찾지 못하는 것 같다.
		// 비슷한 기능을 하는 메소드를 만들어서 호출했더니 잘 동작한다
		// getone()에 문제가 있는건가
		// 근데 아까 강의 시간에 하던 getone()은 특정 번호 잘 데려왔는데 이상하네
		// findOne()이야?
		// 되긴 하는데
		// getOne()은 서블렛 내에서만 사용가능하다. 그래서 안 되는 것이였다 ㅇㅇ
		// 스프링 서블렛(스프링 MVC)에서만 사용가능
		// findOne()은 그런거 상관없이 사용가능함
		// 여기는 자바 애플리케이션 영역이지 서블렛 영역이 아니다 그래서 오류 난거임 ㅇ
		GoodDAO gooddao = (GoodDAO) ctx.getBean("goodDAO");

		//Good good = gooddao.getonemade(1L);
		Good good = gooddao.findOne(1L);
		//Good good = gooddao.getOne(1L);
		System.out.println(good);

	}

}
