package com.chaitea.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MovieService
{
	// .do 가 있는 주소가 들어오면 dispatcherServlet이 반응한다
	// view.do랑 연결된 메소드를 실행시켜준다.
	@RequestMapping("view")
	public ModelAndView viewMovie(@RequestParam("num")Long num2) // 파라미터값이랑 속성 이름이랑 다를 경우에는 리퀘스트 파람으로 엮어준다.
	{
		// ModelAndView 객체 생성
		// 다음에는 객체를 생성하지않고 어노테이션으로 주입받아서 사용할 것이다.
		ModelAndView mav = new ModelAndView();
		
		// ModelAndView에 Object 넣어주기
		// ModelAndView.addObject(K, V);
		mav.addObject("msg", "오브젝트에 넣어서 보내는 메세지"+num2);
		
		// ModelAndView가 갈 주소 넣어주기
		// ModelAndView.setViewName(갈 페이지 이름 주소 ?);
		mav.setViewName("/Hello.jsp");
		
		// 데이터가 들어간 ModelAndView를 돌려보내주기
		return mav;
	}
	
}
