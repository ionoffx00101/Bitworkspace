package com.bitacademy.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeService
{
	// ResponseBody를 사용할때는
	// RequestMapping에 method방식을 설정해줘야 한다.
	// (value = 연결될 주소, method = 전송방식, produces ="한글설정")
	@RequestMapping(value = "/welcome.do", method = RequestMethod.POST, produces = "text/html;charset=utf-8")
	@ResponseBody
	public String welcome(String name)
	{
		// name을 "" 사이에 넣지 않아서
		// 숫자만 인식했던 것이다.
		// "{\"name\":"+name+"}" > {"name":asd}
		// "{\"name\":\""+name+"\"}" > {"name":"asd"}
		return "{\"name\":\""+name+"\"}";
	}
}
