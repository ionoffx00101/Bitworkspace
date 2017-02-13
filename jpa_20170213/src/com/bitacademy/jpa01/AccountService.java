package com.bitacademy.jpa01;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Servlet implementation class MemberService
 */
@Controller
public class AccountService {

	@Autowired
	// 일치하는 걸 알아서 찾아서 엮어주세요..
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
		// 한글화
		request.setCharacterEncoding("UTF-8");
		// 메소드로 구분하기
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
		} else if ("viewAccount".equals(method)) {
			viewAccount(request, response);
		} else {
			viewAccountList(request, response);
		}
	}

	// 한 계좌 조회
	private void viewAccount(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String acnum = request.getParameter("accountnum");

		Account account = accountDAO.getOne(Long.parseLong(acnum)); //  한 줄만 반환한다
		request.setAttribute("account", account);

		RequestDispatcher rd = request.getRequestDispatcher("/account/viewAccount.jsp");
		rd.forward(request, response);

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
		String ownernum = request.getParameter("owner");

		// 파라미터로 받은 값을 비어있는 Account객체에 넣어준다
		Account accout = new Account();
		accout.num = Long.parseLong(num);

		Owner owner = new Owner();
		owner.ownernum = Long.parseLong(ownernum);

		accout.owner = owner;

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

		//List<Account> accoutList = accountDAO.findAll(); // findAll은 jpa에서 만들어준 interface에서 상속받아 쓰는 것이다.
		
		List<Account> accoutList = accountDAO.findAccountBetween(2000000L, 4000000L);
		request.setAttribute("ACCOUNT_LIST", accoutList);

		RequestDispatcher rd = request.getRequestDispatcher("/account/viewAccountList.jsp");
		rd.forward(request, response);

	}

	//서치 계좌 조회
	public void viewAccountListSearch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String searchnum =request.getParameter("search");
		
		List<Account> accoutList = accountDAO.findAccountBalance(Long.parseLong(searchnum)); // findAll은 jpa에서 만들어준 interface에서 상속받아 쓰는 것이다.
		request.setAttribute("ACCOUNT_LIST", accoutList);

		RequestDispatcher rd = request.getRequestDispatcher("/account/viewAccountList.jsp");
		rd.forward(request, response);

	}

}
