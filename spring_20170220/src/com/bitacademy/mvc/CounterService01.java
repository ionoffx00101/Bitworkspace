package com.bitacademy.mvc;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CounterService01
{
	@Inject
	@Named("counter")
	private MyCounter counter;
	
	@RequestMapping("/counter01.do")
	public ModelAndView counter01()
	{
		String msg = counter.getCounter("counter01");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("MSG", msg);
		mav.setViewName("hello.jsp");
		return mav;
	}
}
