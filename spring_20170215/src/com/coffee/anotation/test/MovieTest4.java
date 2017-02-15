package com.coffee.anotation.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.anotation.Movie4;

public class MovieTest4
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml"); // 설정문서 주소
		Movie4 movie = (Movie4) context.getBean("movie4");
		System.out.println(movie);

	}

}
