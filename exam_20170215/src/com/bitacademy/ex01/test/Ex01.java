package com.bitacademy.ex01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.ex01.LoginServiceImpl01;

public class Ex01
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		LoginServiceImpl01 svc = (LoginServiceImpl01) context.getBean("loginServiceImpl01");
		 svc.login("guest", "1234");
		 //svc.login("guest", "12343");
		 //svc.login("guest", "12342");
		 //svc.login("guest", "12344");
		 //svc.login("guest", "12345");
		 //svc.login("guest", "12341");
		 //svc.login("guest", "12342");
		 //svc.login("guest", "12343");
		 
		 ((ConfigurableApplicationContext)context).close();
	}

}
