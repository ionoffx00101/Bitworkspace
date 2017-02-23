package com.bitacademy.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
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
	// "execution(접근연산자^리턴타입^패키지.서비스.메소드(매개변수))"

	// @Before 메소드 실행 전
	@Before("execution(public String com.bitacademy.aop.AService.a1())")
	public void loginBefore(JoinPoint jp)
	{
		Logger logger = Logger.getLogger(getClass());
		logger.warn("LoginAdvice.loginBefore(---------)");
	}

	// @AfterReturning 연결된 메소드가 에러없이 잘 실행이 끝나면 그때
	@AfterReturning("execution(public String com.bitacademy.aop.AService.a1())")
	public void loginAfterReturning(JoinPoint jp)
	{
		Logger logger = Logger.getLogger(getClass());
		logger.warn("LoginAdvice.loginAfterReturning(---------)");
	}

	// @AfterThrowing 연결된 메소드가 에러 있는 상태로 종료시
	@AfterThrowing("execution(public String com.bitacademy.aop.AService.a1())")
	public void loginAfterThrowing(JoinPoint jp)
	{
		Logger logger = Logger.getLogger(getClass());
		logger.warn("LoginAdvice.loginAfterThrowing(---------)");
	}

	// @After 에러가 나든 말든 연결된 메소드가 종료 후 실행
	// @After는 @AfterReturning,@AfterThrowing보다 먼저 실행된다
	@After("execution(public String com.bitacademy.aop.AService.a1())")
	public void loginAfter(JoinPoint jp)
	{
		Logger logger = Logger.getLogger(getClass());
		logger.warn("LoginAdvice.loginAfter(---------)");
	}

	// @Around 연결된 메소드 대신 실행된다. 연결된 메소드는 실행도 안된다.
	// @Around가 사용되면 연결된 메소드가 실행이 안되니 @Before로 설정된것은 실행이 안된다.
	// @After 친구들은 실행된다.
	@Around("execution(public String com.bitacademy.aop.AService.a1())")
	public void loginAround(JoinPoint jp)
	{
		Logger logger = Logger.getLogger(getClass());
		logger.warn("LoginAdvice.loginAround(---------)");
	}
}
