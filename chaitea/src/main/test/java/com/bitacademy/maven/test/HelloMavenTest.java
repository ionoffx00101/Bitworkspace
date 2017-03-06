package com.bitacademy.maven.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.maven.HelloMaven;

public class HelloMavenTest
{

	@Test
	public void testHello()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");

		HelloMaven hello = (HelloMaven) context.getBean("hellomaven");
		String result = hello.hello();
		System.out.println("result = " + result);
		
		((ConfigurableApplicationContext)context).close();
	}

}
