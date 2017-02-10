package com.bitacademy.jpa01;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class MemberService
 */
@Controller
public class AccountService {

	@Resource(name = "stu")
	//스프링님 stu라는 객체를 주세요..
	Student student;

	@Resource(name = "dao")
	AccountDAO accountDAO;

	public AccountService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/AccountService")
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String method = request.getParameter("method");

		if ("viewAccountList".equals(method)) {
			viewAccountList(request, response);
		} else if ("addAccountForm".equals(method)) {
			addAccountForm(request, response);
		} else if ("addAccount".equals(method)) {
			addAccount(request, response);
		} else if ("accountTransferForm".equals(method)) {
			accountTrasferForm(request, response);
		} else if ("accountTransfer".equals(method)) {
			accountTrasfer(request, response);
		} else {
			viewAccountList(request, response);
		}
	}

	//송금
	public void accountTrasfer(HttpServletRequest request, HttpServletResponse response) throws Exception {

	}

	//송금화면으로 이동
	public void accountTrasferForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		RequestDispatcher rd = request.getRequestDispatcher("/account/accountTransferForm.jsp");
		rd.forward(request, response);

	}

	//계좌 생성
	public void addAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 사용자가 입력하고 파라미터로 넘겨준 값을 받는다
		String num = request.getParameter("num");
		String owner = request.getParameter("owner");
		
		// 파라미터로 받은 값을 비어있는 Account객체에 넣어준다
		Account accout = new Account();
		accout.num=Long.parseLong(num);
		accout.owner=owner;
		
		// 데이터 베이스와 연결해주는 DAO에 만들어진 메소드중 저장해주는 기능을 구현한 메소드로 데이터가 들어간 Account를 넘겨준다
		accountDAO.save(accout);
		
		// 전체 조회 페이지로 넘겨준다
		RequestDispatcher rd = request.getRequestDispatcher("AccountService?method=viewAccountList");
		rd.forward(request, response);

	}

	//계좌 생성 화면 이동
	public void addAccountForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		RequestDispatcher rd = request.getRequestDispatcher("/account/addAccountForm.jsp");
		rd.forward(request, response);

	}

	//전체 계좌 조회
	public void viewAccountList(HttpServletRequest request, HttpServletResponse response) throws Exception {

		//request.setAttribute("STUDENT", student);

		List<Account> accoutList = accountDAO.findAll();
		request.setAttribute("ACCOUNT_LIST",accoutList);

		RequestDispatcher rd = request.getRequestDispatcher("/account/viewAccountList.jsp");
		rd.forward(request, response);
	}

}
