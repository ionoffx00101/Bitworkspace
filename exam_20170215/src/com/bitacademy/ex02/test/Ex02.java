package com.bitacademy.ex02.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.ex02.service.LoginServiceImpl02;

public class Ex02
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		LoginServiceImpl02 svc = (LoginServiceImpl02)context.getBean("loginServiceImpl02");
		//svc.login("guest", "1234");
		svc.login("guest", "12345"); // 비번 못 잡음 > != 에서 equals로 문자열 비교하게 했더니 이제 잡음
		svc.login("guest", "12345");
		svc.login("guest", "12345");
		svc.login("guest", "12345");
		svc.login("guest", "12345");
		svc.login("guest", "12345");
		svc.login("guest", "12345");
		svc.login("guest", "12345");
		//svc.login("g", "1234"); // 존재하지 않는 아이디 잘 됨
		
	}

}
