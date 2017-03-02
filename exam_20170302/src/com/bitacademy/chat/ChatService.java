package com.bitacademy.chat;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//1.	컨트롤러 설정
@Controller
public class ChatService {
  //2.	ModelAndView 속성 주입받음	
  @Resource
  private ModelAndView mav;

  //A.	addChatForm.do 로 요청했을때 실행
  @RequestMapping(value = "addChatForm.do")
  public ModelAndView addChatForm(HttpSession session) {
	//B.	/chat/addChatForm.jsp 로 페이지 이동  
    mav.setViewName("/chat/addChatForm.jsp");
    return mav;
  }
}
