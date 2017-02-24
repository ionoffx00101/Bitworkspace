package com.bitacademy.advice;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAdvice02
{
	// @Around 메소드를 감싸고 실행한다
	@Around("execution( * com.bitacademy.cus.CustomerService.ViewCustomer(..)) || execution( * com.bitacademy.cus.CustomerService.edit*(..))")
	public String loginCheck(ProceedingJoinPoint pJoinPoint) throws Throwable
	{
		// 들어온 세션이 null이 아니면 감싸둔 메소드를 실행한다.
		// null이면 이 로그인 체크가 String한줄을 대신 리턴하고 턴을 종료한다.

		// .getArgs() 컨트롤러의 매개변수를 리턴
		Object[] args = pJoinPoint.getArgs();
		for (int i = 0; i < args.length; i++)
		{
			// 객체를 하나씩 뽑음
			Object arg = args[i];
			// 많은 객체 중 Session이랑 일치하는 객체를 찾음 / instanceof
			if (arg instanceof HttpSession)
			{
				// arg 형변환
				HttpSession session = (HttpSession) arg;
				if (session.getAttribute("login_customer") != null)
				{
					System.out.println("login check");
					// @Around가 감싸고 있는 원래 메소드를 실행함
					pJoinPoint.proceed();
					// 로그인 됨
					System.out.println("login 됨");
					// 메소드를 끝내기 위해
					return null;
				}
			}
		}

		System.out.println("로그인을 하세요");
		// 로그인 페이지로 보내버림
		return "index.jsp";
	}
}
