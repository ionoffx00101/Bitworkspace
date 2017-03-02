package com.bitacademy.account;

public class Account {
	private long balance;//잔액
	private String accountPw; //비번
	private String ownernum;//주인 주민번호

	
	
	public Account() {
		super();
	}
	


	public Account(long balance, String accountPw, String ownernum) {
		super();
		this.balance = balance;
		this.accountPw = accountPw;
		this.ownernum = ownernum;
	}

	

	public long getBalance() {
		return balance;
	}



	public void setBalance(long balance) {
		this.balance = balance;
	}



	public String getAccountPw() {
		return accountPw;
	}



	public void setAccountPw(
			String 비번바꿀려는사람주민번호,String 옛날비번,
			String 새비번)
		throws PasswordException,OwnerException{
		if(비번바꿀려는사람주민번호.equals(ownernum)){
			if(옛날비번.equals(accountPw)){
				accountPw=새비번;
			}else{
				 throw new PasswordException("비번오류");
			}
		}else{
			 throw new OwnerException("주민번호 확인 오류");
		}
	}



	public String getOwnernum() {
		return ownernum;
	}



	public void setOwnernum(String ownernum) {
		this.ownernum = ownernum;
	}

	

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", accountPw=" + accountPw
				+ ", ownernum=" + ownernum + "]";
	}



	public void deposit(long inmoney,String pw)
			throws PasswordException{
		if(pw.equals(accountPw)){
			balance+=inmoney;
		}else{
			throw new PasswordException("비밀번호 오류");
		}
	}
	public void withdraw(long outmoney,String pw)
	 throws BalanceException,PasswordException
	   ,InterruptedException{
		Thread.sleep(10000);
		
		if(pw.equals(accountPw)){
			if(outmoney<=balance){
			  balance-=outmoney;
		    }else{
		    	throw new BalanceException("잔액 부족");
		    }
		}else{
			throw new PasswordException("비번 오류");
		}
	}
}
