package com.bitacademy.account.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bitacademy.account.Account;
import com.bitacademy.account.BalanceException;

public class AccountTest {

	@Test
	public void test01()throws Exception {
		Account acc=new Account(
				1000000,"1234","800101-1234567");
		//acc.setAccountPw("1234");
		//acc.setBalance(1000000);
		//acc.setOwnernum("900101-2345678");
		
		acc.deposit(5000000,"1234");
		
		assertEquals("입금 오류",6000000,acc.getBalance());
		
		acc.withdraw(2000000,"1234");
		
		assertNotEquals("출금오류",6000000,acc.getBalance());
		
	}

	@Test
	public void test02()throws Exception {
		Account acc=new Account(
				1000000,"1234","800101-1234567");
		acc.setAccountPw("800101-1234567","1234","0070");
		
		assertTrue("비번 수정 오류",
				"0070".equals(acc.getAccountPw()));
		
		assertFalse("비번 수정 오류",
				"1234".equals(acc.getAccountPw()));
	}

	@Test(expected=BalanceException.class)
	public void test03()throws Exception {
		Account acc=new Account(
				1000000,"1234","800101-1234567");
		acc.withdraw(50000000,"1234");
	}

	@Test(timeout=5000)
	public void test04()throws Exception {
		Account acc=new Account(
				1000000,"1234","800101-1234567");
		acc.withdraw(500000,"1234");
	}

}
