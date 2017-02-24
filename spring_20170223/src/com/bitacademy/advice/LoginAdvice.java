package com.bitacademy.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 여기 저기 컨트롤러에서 공통적으로 호출하는 메서드 loginCheck 를 포함 클래스
// = Advice
// 컨트롤러에서 직접 호출 안함
// 스프링이 알아서 호출하도록 설정( PointCut )

// @Aspect 이 클래스의 메서드는 스프링이 알아서 호출할 것이다.
@Aspect
@Component
public class LoginAdvice
{
	// @Pointcut 이 메서드를 스프링이 언제 자동으로 호출 할지 설정
	// @Pointcut("")
	// "execution(접근제한자^리턴타입^패키지.서비스.메소드(매개변수))"

	// @Before + OR / 설정된 둘 중 한 메소드가 실행 전 / 줄 바뀌면 안된다.
	//@Before("execution(public String com.bitacademy.aop.AService.a1()) || execution(public String com.bitacademy.aop.AService.a2())")
	public void loginBeforeOR(JoinPoint jp)
	{
		Logger logger = Logger.getLogger(getClass());
		logger.warn("LoginAdvice.loginBeforeOR(||||||||||||||||||||||)");
	}
	// @Before + Wildcard / 설정된 메소드가 실행 전 
	// .*.(*) 아무거나..
	//@Before("execution(public String com.bitacademy.aop.AService.c*(*,..)))")
	public void loginBeforeWildcard(JoinPoint jp)
	{
		Logger logger = Logger.getLogger(getClass());
		logger.warn("LoginAdvice.loginBeforeWildcard(*************)");
	}

}
