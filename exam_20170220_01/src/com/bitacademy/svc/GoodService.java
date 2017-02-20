package com.bitacademy.svc;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bitacademy.dao.GoodDAO;

@Controller
public class GoodService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("goodDAO")
	private GoodDAO goodDAO;

	@RequestMapping("/viewGoodList.do")
	public ModelAndView viewGoodList()
	{
		mav.addObject("goodList", goodDAO.findAll());
		mav.setViewName("/viewGoodList.jsp");
		return mav;
	}

	@RequestMapping("/viewGood.do")
	public ModelAndView viewGood(Long gnum)
	{
		mav.addObject("good", goodDAO.findOne(gnum));
		mav.setViewName("/viewGood.jsp");
		return mav;
	}
}
