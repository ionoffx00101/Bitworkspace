package com.bitacademy.cus;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// 컨트롤러니까 컨트롤러 넣어주자 그러자
@Controller
@Component("customerService")
public class CustomerService
{
	private Logger logger = Logger.getLogger(getClass());

	@Inject
	@Named("mav")
	private ModelAndView mov; // requestScope라서 Debug해주는 친구가 오류인줄 안다.. requestScope는 진짜 웹에서만 된다.

	// session값을 받기 위한 HttpSession 객체
	@RequestMapping("/login.do")
	public String login(String id, String pw, HttpSession session)
	{
		Customer customer = new Customer(id, pw, null);
		logger.warn("login");
		session.setAttribute("login_customer", customer);
		logger.warn("login infomation save in session");

		return "hello.jsp";
	}

	public void addCustomer(Customer customer)
	{
		logger.warn("this is addCustomer first line");
	}

	public void addCustomerForm()
	{
		logger.warn("this is addForm first line");
	}

	// 로그인한 사용자만 이용 가능 /  @Before logincheck
	// 회원의 자세한 정보를 조회할 수 있는 페이지
	public void ViewCustomer(String userid,HttpSession session) // Advice에서 JoinPoint로 session을 꺼내기 위해 컨트롤러가 매개변수로 HttpSession session을 받음
	{
		logger.warn("this is addView first line");
	}
	
	// 로그인한 사용자만 이용가능 /  @Before logincheck
	// 자신의 회원 정보 수정 하는 페이지로 연결함
	public void editCustomerForm(String id,HttpSession session) // 다 넣어줘야하는 것같다.
	{
		logger.warn("this is editCustomerForm first line");
	}
	// 로그인한 사용자만 이용가능 /  @Before logincheck
	// 자신의 회원 정보를 수정하는 기능
	public void editCustomer(Customer customer,HttpSession session)
	{
		logger.warn("this is editCustomer first line");
	}
}
