package com.bitacademy.user;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("userDAO")
	private UserDAO userDAO;

	@RequestMapping(value = "loginForm.do") // 디스팩쳐에 / 처리 되어있어서 사실 do 안붙여도 갈듯
	public ModelAndView loginForm()
	{
		mav.setViewName("/login/loginForm.jsp");
		return mav;
	}

	@RequestMapping(value="login.do",method=RequestMethod.POST)//
	public ModelAndView login(String id, String pw, HttpSession socket)
	{
		User loginUser = userDAO.findOne(id);
		if (loginUser != null)
		{
			// 존재하는 아이디면 비번 확인도 해야함
			if(loginUser.getPw().equals(pw)){
				//둘다 맞으면 빵긋 성공함
				socket.setAttribute("login_user",loginUser);
				mav.setViewName("addChatForm.do");
			}
			else
			{
				// 다름 로그인 실패임
				mav.addObject("ERROR","비밀번호 오류");
				mav.setViewName("forward:loginForm.do");
			}
		}
		else if(loginUser==null)
		{
			// 존재하지 않는 아이디면 ERROR를 저장
			mav.addObject("ERROR","존재하지 않는 아이디");
			mav.setViewName("forward:loginForm.do");
		}
		if(mav.getViewName()==null){
		mav.setViewName("forward:loginForm.do");
		}
		return mav;
	}
}
