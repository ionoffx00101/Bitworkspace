package com.bitacademy.mvc;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PCounterService01
{
	@Inject
	@Named("counter02")
	private IMyCounter counter;

	@RequestMapping("/pcounter01.do")
	public ModelAndView counter01()
	{
		String msg = "<h1>counter01.do</h1>";
		msg += "<h1>counter=" + counter + "</h1>";
		for (int i = 0; i < 10; i++)
		{
			long number = counter.getNum();
			counter.setNum(++number);
			msg += "<h1>counter.num=" + counter.getNum() + "</h1>";
		}

		ModelAndView mav = new ModelAndView();
		mav.addObject("MSG", msg);
		mav.setViewName("hello.jsp");
		return mav;
	}
}
