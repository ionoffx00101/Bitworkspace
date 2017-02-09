package com.bitacademy.jpa01;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_contact")
public class Contact {

	@Id
	public Long cid;
	public String phoneNum;
	
	// contact 한줄에 worker 한줄 one to one
	// @JoinColumn(name="참고를 하는 테이블의 컬럼명",referencedColumnName="참조를 당하는 테이블의 컬럼명")
	// @JoinColumn(name="tb_contact.workerid", referencedColumnName="tb_worker.workerid")
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="workerid", referencedColumnName="workerid")
	public Worker worker;
	
	public Long getCid() {
		return cid;
	}
	public void setCid(Long cid) {
		this.cid = cid;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public Worker getWorker() {
		return worker;
	}
	public void setWorker(Worker worker) {
		this.worker = worker;
	}
	
	// 무한 재귀 호출이 일어나서 toString안에서 호출하는 worker를 빼주었다.
	@Override
	public String toString() {
		return "Contact [cid=" + cid + ", phoneNum=" + phoneNum + "]";
	}
	
	
}
