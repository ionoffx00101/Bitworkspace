package com.coffee.svc;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.coffee.dao.CollegeDAO;
import com.coffee.dao.CustomerDAO;
import com.coffee.dao.DeptDAO;
import com.coffee.vo.Customer;

@Controller
public class CustomerService
{
	@Inject
	@Named("mav")
	private ModelAndView mav;

	@Inject
	@Named("collegeDAO")
	private CollegeDAO collegeDAO;

	@Inject
	@Named("deptDAO")
	private DeptDAO deptDAO;

	@Inject
	@Named("customerDAO")
	private CustomerDAO customerDAO;

	@RequestMapping(value="/addCustomerForm.do")
	public ModelAndView addCustomerForm()
	{
		Long searchDeptno = 100L;
		
		mav.addObject("collegeList",collegeDAO.findAll());
		mav.addObject("deptList",deptDAO.selectDeptList(searchDeptno));
		mav.setViewName("addCustomerForm.jsp");
		return mav;
	}

	@RequestMapping(value="/idCheck.do",produces="text/html;charset=utf-8",method=RequestMethod.POST)//"application/json;charset=UTF-8"
	@ResponseBody
	public String idCheck(String userid)
	{
		Customer findCustomer = customerDAO.findOne(userid);
		
		if (findCustomer!=null)
		{
			return "사용중인 아이디";
		}
		return "사용 할 수 있는 아이디";
	}

	@RequestMapping(value="/viewDeptList.do",produces="application/json;charset=UTF-8",method=RequestMethod.POST)
	@ResponseBody
	public Object viewDeptList(Long colno)
	{
		
		return deptDAO.selectDeptList(colno); // 너무 간단해서 걱정되는걸
	
	}
	
	@RequestMapping(value="/addCustomer.do")
	public String addCustomer(Customer customer)
	{
		System.out.println(customer);
		customerDAO.save(customer);
		return "redirect:/viewGoodList.do";
	}
}
