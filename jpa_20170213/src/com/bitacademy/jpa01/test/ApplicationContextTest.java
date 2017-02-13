package com.bitacademy.jpa01.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.jpa01.AccountDAO;


public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		System.out.println("ctx : " + ctx);
		
		// 형변환 해서 받아주기도 해야한다 이거 너무 귀찮아보인다 
		AccountDAO acc = (AccountDAO) ctx.getBean("accountDAO"); // 자바빈 설정중에 이름이 accountDAO를 찾아서 보여달라는 건가?	
		System.out.println(acc.findAll());
	}
}
