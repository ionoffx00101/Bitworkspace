package com.coffee.MVC.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.coffee.MVC.MovieService;

public class MovieServiceTest
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");// 설정파일 경로 넣어주기
		
		MovieService movieService1 = (MovieService) context.getBean("movieService"); // 공유영역에서 찾으려는 객체의 이름을 넣기 > 그 객체 타입으로 형변환
		System.out.println("1 " + movieService1);
		MovieService movieService2 = (MovieService) context.getBean("movieService"); // 정말 같은 객체를 돌려쓰는 건지 확인할 것이다
		System.out.println("2 " + movieService2);
		MovieService movieService3 = (MovieService) context.getBean("movieService"); // 같은 주소값인지 비교하면 된다
		System.out.println("3 " + movieService3);

		// 결과 
		// 1 MovieService [movieDAO = com.coffee.MVC.MovieDAO@510f3d34, MovieService의 객체 주소 = 2014838114]
		// 2 MovieService [movieDAO = com.coffee.MVC.MovieDAO@510f3d34, MovieService의 객체 주소 = 2014838114]
		// 3 MovieService [movieDAO = com.coffee.MVC.MovieDAO@510f3d34, MovieService의 객체 주소 = 2014838114]
		
	}

}
