package com.bitacademy.jpa01;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity // 이 클래스는 entity랑 연결되어있다
@Table(name="tb_account2") // 이 테이블이랑 연결되어있따
public class Account {

	@Id
	//@Column(name="")  아래 써진 변수명이랑 컬럼명이 다르면 이 어노미테이션을 사용해서 나와 컴파일러에게 알려준다
	public Long num;
	public Long balance;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="ownernum",referencedColumnName="ownernum")//(name="내 컬럼명",referencedColumnName="재 컬럼명")
	public Owner owner;

	public Long getNum() {
		return num;
	}

	public void setNum(Long num) {
		this.num = num;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Account [num=" + num + ", balance=" + balance + ", owner=" + owner + "]";
	}
	
}
