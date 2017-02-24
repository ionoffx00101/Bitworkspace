package com.bitacademy.car;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarService
{	
	@Autowired
	private ModelAndView mav;

	@RequestMapping(value="/viewCarListForm.do",method=RequestMethod.GET)
	public Object viewCarListForm()
	{
		ArrayList<Brand> brandList = new ArrayList<Brand>(); // new ArrayList<Brand>() ? new ArrayList<>()
		brandList.add(new Brand("101", "tobo"));
		brandList.add(new Brand("102", "gobo"));
		brandList.add(new Brand("103", "tubo"));
		
		mav.addObject("brandList", brandList);
		mav.setViewName("viewCarListForm.jsp");
		
		return mav;
	}

	@RequestMapping(value="/viewCarListForm.do", produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public Object viewCarListForm(String code)
	{	
		ArrayList<Car> carList = new ArrayList<>();
		
		if("101".equals(code)){
			carList.add(new Car("1011","toooo"));
			carList.add(new Car("1012","goooo"));
		}
		else if ("102".equals(code)) {
			carList.add(new Car("2011","tiiiiii"));
			carList.add(new Car("2012","giiiiiiii"));
		}else {
			carList.add(new Car("3011","teeeeeeee"));
			carList.add(new Car("3012","geeeeee"));
		}

		mav.addObject("carList", carList);
		mav.setViewName("viewCarListForm.jsp");
		
		return carList;
	}
}
