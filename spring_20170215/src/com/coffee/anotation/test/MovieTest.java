package com.coffee.anotation.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.anotation.Movie;

public class MovieTest
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml"); // 설정문서 주소
		Movie movie = (Movie) context.getBean("movie");
		System.out.println(movie);
		((ConfigurableApplicationContext)context).close();
	}

}
