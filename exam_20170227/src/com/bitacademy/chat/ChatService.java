package com.bitacademy.chat;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChatService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@RequestMapping("addChatForm.do")
	public ModelAndView addChatForm(HttpSession session)
	{
		mav.setViewName("/chat/addChatForm.jsp");
		return mav;
	}
}
