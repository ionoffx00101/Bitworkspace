package com.bitacademy.user;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserService {
  @Autowired
  private ModelAndView mav;
  @Autowired
  private UserDAO userDAO;
  
  //A.	loginForm.do 로 요청했을때 실행
  @RequestMapping(value = "loginForm.do")
  public ModelAndView loginForm() {
	//B.	ModelAndView 속성이용해서 /login/loginForm.jsp로 이동  
    mav.setViewName("/login/loginForm.jsp");
    return mav;
  }

  //A.	login.do 로 요청했을때 실행
  @RequestMapping(value = "/login.do")
  public ModelAndView login(String id, String pw, HttpSession session) throws Exception {
    /*
     * B.	UserDAO.findOne(입력한아이디) 호출해서 리턴값을 변수 loginUser에 저장
		i.	입력한 아이디는 매개변수 id 에 저장되있음
     */
	  User loginUser = userDAO.findOne(id);
    //C.	존재하지 않는 아이디라서 loginUser 가 null 이면 
    if (loginUser == null) {
      //i.	"존재하지 않는 아이디 입니다" 라는 정보를 ModelAndView 속성에 속성명 ERROR 으로  저장하고	
      mav.addObject("ERROR", "존재하지 않는 아이디 입니다");
      //ii.	loginForm.do 으로 이동하도록 설정 (forward:/  사용)
      mav.setViewName("forward:/loginForm.do");
      //iii.	ModelAndView 속성 리턴
      return mav;
    }
    //D.	loginUser의 비밀번호와 입력한 비밀번호가 다르면
    if (!loginUser.getPw().equals(pw)) {
    	//i.	"비밀번호 오류 입니다" 라는 정보를 ModelAndView 속성에 속성명 ERROR 으로  저장하고
      mav.addObject("ERROR", "비밀번호 오류 입니다");
      //ii.	loginForm.do 으로 이동하도록 설정 (forward:/  사용)
      mav.setViewName("forward:/loginForm.do");
      //iii.	ModelAndView 속성 리턴 
      return mav;
    }
    //E.	로그인에 성공했으면
    //i.	세션에 로그인한 회원정보 loginUser변수를 LOGIN_USER 라는 이름으로 저장하고
    session.setAttribute("LOGIN_USER", loginUser);
    //ii.	addChatForm.do 으로 페이지 이동하도록 설정 (forward:/  사용)
    mav.setViewName("forward:/addChatForm.do");
    //F.	ModelAndView 속성 리턴
    return mav;
  }
}
