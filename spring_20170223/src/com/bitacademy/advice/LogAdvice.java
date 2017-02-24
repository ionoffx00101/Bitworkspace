package com.bitacademy.advice;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// aspect니까 aspect붙여주자
@Aspect
@Component
public class LogAdvice
{
	//@Before("execution( * com.bitacademy.cus.*.*(..))")
	public void log(JoinPoint joinPoint)
	{
		// 타켓이 된 컨트롤러를 데려온다
		Object controller = joinPoint.getTarget();
		// 타켓이 된 메소드 호출
		Signature method=joinPoint.getSignature();
		// 매개변수 호출
		Object[] args = joinPoint.getArgs();
		
		// 데려온걸 로그로 찍어보자
		// 데려온 컨트롤러의 클래스를 넣자
		Logger logger = Logger.getLogger(controller.getClass());
		logger.warn(" ");
		logger.warn("LogAdvice.log() start");
		logger.warn(controller);
		logger.warn(method);
		logger.warn(args);
		for (int i = 0; i < args.length; i++)
		{
			logger.warn(args[i]);
		}
		logger.warn("LogAdvice.log() end");
		logger.warn(" ");
		
	}
}
