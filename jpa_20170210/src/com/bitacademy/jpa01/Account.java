package com.bitacademy.jpa01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/*
 
 drop table tb_account;
 
 create table tb_account(
   num number primary key,
   balance number,
   owner varchar2(30)
   );
   
   insert into tb_account values (1,10000000000,'홍길동');
   insert into tb_account values (2,100,'홍길순');
   insert into tb_account values (3,10000,'김태희');
   insert into tb_account values (4,0,'장동건');
   insert into tb_account values (5,10000,'고소영');
   insert into tb_account values (6,20000,'권상우');
   insert into tb_account values (7,30000,'공유');
   insert into tb_account values (8,40000,null);
   insert into tb_account values (9,50000,'장영란');
   insert into tb_account values (10,60000,'장미희');
     commit;
  
 */
@Entity
@Table(name="TB_ACCOUNT")
public class Account {
	@Id
	Long num;
	Long balance;
	String owner;
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
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	@Override
	public String toString() {
		return "Account [num=" + num + ", balance=" + balance + ", owner=" + owner + "]";
	}
	
	
	
}
