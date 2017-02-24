package com.bitacademy.cus.test;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;

import com.bitacademy.cus.CustomerService;

public class CustomerServiceTest
{

	@Test
	public void testLogin()
	{
		// mockhttp 가 seesion을 가지고 있다 착한 친구다.
		MockHttpServletRequest mockRequest = new  MockHttpServletRequest();
		HttpSession session = mockRequest.getSession();
		
		// 이제 평소 하던 대로 테스트 하면 된다
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		CustomerService svc = (CustomerService) context.getBean("customerService");
		
		// 로그인을 함
		//svc.login("dd", "1234", session);
		System.out.println("session : "+session);
		System.out.println("로그인 정보 : "+session.getAttribute("login_customer"));
		
		// 회원 정보를 봄
		svc.ViewCustomer("guest", session);
		
		svc.editCustomer(null, session);
		svc.editCustomerForm("guest", session);
		
		((ConfigurableApplicationContext)context).close();
	}

}
