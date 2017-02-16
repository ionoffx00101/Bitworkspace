package com.coffee.Inter.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.Inter.MovieInterService3;

public class MovieInterServiceTest3
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");// 설정파일 경로 넣어주기

		MovieInterService3 src = (MovieInterService3) context.getBean("movieInterService3"); // 공유영역에서 찾으려는 객체의 이름을 넣기 > 그 객체 타입으로 형변환
		System.out.println(src);
		((ConfigurableApplicationContext)context).close();
	}

}
