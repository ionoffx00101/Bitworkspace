package com.bitacademy.aop;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class LoginAdvice
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	// @Around 메소드를 감싸고 실행한다
	@Around("execution( * com.bitacademy.chat.ChatService.*(..))")
	public ModelAndView loginCheck(ProceedingJoinPoint joinpoint) throws Throwable
	{
		Object[] args = joinpoint.getArgs();

		for (int i = 0; i < args.length; i++)
		{
			// 첫번째 매개변수를 뽑음
			Object arg = args[i];
			if (arg instanceof HttpSession)
			{
				// 첫번째 매개변수 형변환
				HttpSession session = (HttpSession) arg;

				if (session.getAttribute("login_user") != null)
				{

					joinpoint.proceed();
					// 메소드를 끝내기위해 그냥 비어있는 mav객체를 보내준다.
					return mav;
				}
			}
		}
		mav.addObject("ERROR", "로그인이 필요합니다");
		mav.setViewName("forward:loginForm.do");
		return mav;

	}
}
