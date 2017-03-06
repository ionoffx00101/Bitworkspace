package com.bitacademy.maven;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("hellomaven")
public class HelloMaven
{
	@RequestMapping("hello.do")
	public String hello()
	{
		return "hello.jsp";
	}
}
