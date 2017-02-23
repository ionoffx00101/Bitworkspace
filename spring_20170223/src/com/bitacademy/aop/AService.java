package com.bitacademy.aop;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

//스프링이 객체를 호출할 수 있게 @Component도 넣어주자
@Controller
@Component("aService")
public class AService
{
	private Logger logger = Logger.getLogger(getClass());
	
	public String a1(int num)
	{
		logger.warn("AService.a1(int num)");
		return "a1";
	}
	public String a1()
	{
		logger.warn("-1- AService.a1( )");
		
//		int a =10;
//		int b=0;
//		int c=a/b;
		
		logger.warn("-2- AService.a1( )");
		
		return "a1";
	}
	public String a2()
	{
		logger.warn("AService.a2( )");
		return "a2";
	}
}
