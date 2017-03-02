package com.bitacademy.aop;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.user.User;

@Aspect
@Component
public class LoginAdvice {
  @Resource
  private ModelAndView mav;
  //1.com.bitacademy.chat.ChatService의 모든 메서드를 호출할때 대신(Around) 실행하도록 포인트컷 설정
  @Around(value = "execution(* com.bitacademy.chat.ChatService.*(..))")
  public ModelAndView loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
    ////1.타겟 오브젝트의 매개변수들을 리턴받아서 변수에 저장
	Object[] args = joinPoint.getArgs();
	//2. 1의 첫번째 매개변수를 리턴받아서 변수에 저장
    Object obj=args[0];
  //3. 2을 HttpSession 타입 변수에 형변환해서 저장
    HttpSession session=(HttpSession)obj;
  //4. 3에서 LOGIN_USER 속성을 꺼내서 변수에 저장
    User loginUser = (User) session.getAttribute("LOGIN_USER");
    //5. 4 가 null 이면 
    if (loginUser == null) {
      //mav에 "로그인이 필요합니다" 메시지 저장 (addObject 이용, 속성이름 ERROR) 
      mav.addObject("ERROR", "로그인이 필요합니다");
      // mav 속성에 viewName을 forward:/loginForm.do 로 저장 
      mav.setViewName("forward:/loginForm.do");
      // mav 리턴	
      return mav;
    }
    //6. 4가 null 이 아니면 타겟 메서드 호출 joinPoint.proceed();하고 리턴된 값을 변수에 저장
    ModelAndView proceed=(ModelAndView) joinPoint.proceed();
    //7. 6의 리턴값 리턴
    return proceed;
  }
}
