package com.bitacademy.advice.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bitacademy.cus.CustomerService;


public class LogAdviceTest
{

	@Test
	public void test()
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		CustomerService svc = (CustomerService) context.getBean("customerService");
		
		svc.addCustomerForm();
		//svc.ViewCustomer("userid");
		
		((ConfigurableApplicationContext)context).close();
	}

}
