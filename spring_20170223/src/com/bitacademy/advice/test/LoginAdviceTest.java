package com.bitacademy.advice.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.aop.AService;

public class LoginAdviceTest
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		AService service = (AService) context.getBean("aService");
		service.a2();
		System.out.println("a2( ) END");
		
		service.a1(100);
		System.out.println("a1(int i) END");
		
		service.a1();
		System.out.println("a1( ) END");
		
		((ConfigurableApplicationContext)context).close();
	}

}
