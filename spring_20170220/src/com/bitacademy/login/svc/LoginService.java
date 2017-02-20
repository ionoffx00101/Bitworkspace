package com.bitacademy.login.svc;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.login.di.User;

@Controller
public class LoginService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("loginUser")
	private User loginUser;

	@RequestMapping("viewMain")
	public ModelAndView viewMain(){
		mav.addObject("login_user",loginUser);
		mav.setViewName("/login/viewMain.jsp");
		return mav;
	}
	
	@RequestMapping("loginForm")
	public String loginForm(){

		return "/login/loginForm.jsp";
	}
	
	@RequestMapping("login")
	public ModelAndView login(String id,String pw){

		loginUser.setId(id);
		loginUser.setPw(pw);
		
		mav.addObject("login_user",loginUser);
		mav.setViewName("/login/viewMain.jsp");
		return mav;
	}
}
