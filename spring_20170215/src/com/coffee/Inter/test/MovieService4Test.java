package com.coffee.Inter.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.Inter.MovieService4;

public class MovieService4Test
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");// 설정파일 경로 넣어주기

		MovieService4 src = (MovieService4) context.getBean("movieService4"); // 공유영역에서 찾으려는 객체의 이름을 넣기 > 그 객체 타입으로 형변환
		System.out.println(src);
		((ConfigurableApplicationContext) context).close();
	}

}
