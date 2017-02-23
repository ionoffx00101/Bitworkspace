package com.coffee.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

import com.coffee.vo.College;
import com.coffee.vo.Customer;
import com.coffee.vo.Dept;

public class CustomerArgumentResolver implements WebArgumentResolver
{

	@Override
	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest request) throws Exception
	{
		// 메소드 파라미터 타입이 Customer일때만 끼어든다
		if (methodParameter.getParameterType() == Customer.class)
		{
			// 데이터 담을 객체를 만든다.
			// Customer>Dept>College 셋 다 포함하고 있다 나쁜 아이다.
			// 데이터 넣을 객체를 다 만들어주자
			Customer customer = new Customer();
			Dept dept = new Dept();
			College college = new College();

			// 데이터를 넣자
			customer.setName(request.getParameter("name"));
			customer.setUserid(request.getParameter("userid"));
			customer.setPw(Integer.parseInt(request.getParameter("pw")));

			dept.setDeptno(Long.parseLong(request.getParameter("deptno")));
			
			college.setColno(Long.parseLong(request.getParameter("colno")));

			// 합체해주자
			dept.setCollege(college);
			customer.setDept(dept);

			// 데이터가 잔뜩 들어간 Customer를 리턴
			return customer;
		}
		// 기본 리턴값 WebArgumentResolver.UNRESOLVED 난 아무것도 안하고 서블렛으로 넘어간다.
		return WebArgumentResolver.UNRESOLVED;
	}

}
