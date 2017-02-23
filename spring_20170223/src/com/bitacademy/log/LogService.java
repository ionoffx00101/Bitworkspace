package com.bitacademy.log;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@RequestMapping("/helloLog.do")
	public ModelAndView helloLog()
	{
		Logger logger = Logger.getLogger(getClass());
		// getClass() 하면 현재 파일인 LogService의 클래스를 리턴한다.
		// this.getClass() ?
		// log4j.xml에 root에 레벨 설정보다 낮은 메시지는 보이지 않는다.
		logger.debug("debug World"); // debug 레벨의 로그 메시지
		logger.info("info World"); // Info 레벨의 로그 메시지
		logger.warn("warn World"); // warn 레벨의 로그 메시지
		logger.error("error World"); // error 레벨의 로그 메시지
		logger.fatal("fatal World"); // fatal 레벨의 로그 메시지
		mav.addObject("msg", "콘솔창 봐");
		mav.setViewName("hello.jsp");
		return mav;
		
		// root 설정 Info
		// 2017-02-23 13:36:32,819 INFO [com.bitacademy.log.LogService] info World []
		// 2017-02-23 13:36:32,820 WARN [com.bitacademy.log.LogService] warn World []
		// 2017-02-23 13:36:32,820 ERROR [com.bitacademy.log.LogService] error World []
		// 2017-02-23 13:36:32,820 FATAL [com.bitacademy.log.LogService] fatal World []
	}
}
