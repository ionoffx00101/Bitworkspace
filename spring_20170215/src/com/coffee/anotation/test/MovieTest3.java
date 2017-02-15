package com.coffee.anotation.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.anotation.Movie3;

public class MovieTest3
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml"); // 설정문서 주소
		Movie3 movie = (Movie3) context.getBean("movie3");
		System.out.println(movie);

	}

}
