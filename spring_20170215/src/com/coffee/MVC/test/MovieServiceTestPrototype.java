package com.coffee.MVC.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.MVC.MovieServicePrototype;

public class MovieServiceTestPrototype
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");// 설정파일 경로 넣어주기
		
		MovieServicePrototype movieService1 = (MovieServicePrototype) context.getBean("movieServicePrototype"); // 공유영역에서 찾으려는 객체의 이름을 넣기 > 그 객체 타입으로 형변환
		System.out.println("1 " + movieService1);
		MovieServicePrototype movieService2 = (MovieServicePrototype) context.getBean("movieServicePrototype"); // 정말 다른 객체를 만들어주는지 확인할 것이다
		System.out.println("2 " + movieService2);
		MovieServicePrototype movieService3 = (MovieServicePrototype) context.getBean("movieServicePrototype"); // 다른 주소값인지 비교하면 된다
		System.out.println("3 " + movieService3);

		// 결과 
		// 1 MovieServicePrototype [movieDAO = com.coffee.MVC.MovieDAO@5e5d171f, MovieServicePrototype의 객체 주소 = 607207372]
		// 2 MovieServicePrototype [movieDAO = com.coffee.MVC.MovieDAO@5e5d171f, MovieServicePrototype의 객체 주소 = 131206411]
		// 3 MovieServicePrototype [movieDAO = com.coffee.MVC.MovieDAO@5e5d171f, MovieServicePrototype의 객체 주소 = 2012330741]
		((ConfigurableApplicationContext)context).close();
	}

}
