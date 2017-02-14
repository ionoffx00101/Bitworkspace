package com.coffee.spring01.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.spring01.MyObject;
import com.coffee.spring01.iocServiceImple;

public class MyObjectTest {

	@Test
	public void testHelloIoc() {
		@SuppressWarnings("resource") //????
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		// 아까전에 만든 객체를 불러와서 테스트
		MyObject obj = (MyObject) context.getBean("obj");
		
		System.out.println(obj);
		
	}

}