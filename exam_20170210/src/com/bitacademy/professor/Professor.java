package com.bitacademy.professor;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/*교수정보를 저장하고 있는 객체
 * 1. TB_PROFESSOR 테이블과 데이터를 주고 받도록 설정
 * */
@Entity
@Table(name="TB_PROFESSOR")
public class Professor {
	//2.Primary Key 설정
	@Id
	public Long profno;//교수번호
	public String name;//이름
	public String userid;//아이디
	public String position;//직책
	public Long sal;//월급
	public Date hiredate;//입사일
	public String comm;//성과급
	
	/*
	 * 3.TB_PROFESSOR 테이블과 TB_DEPARTMENT 테이블이 조인되도록 설정하시오
	 *  관계를 1:1 이고 
	 *  각 테이블은 deptno 컬럼의 값이 일치하는 레코드를 조인할것임
	 * */
	@JoinColumn(name="deptno",referencedColumnName="deptno")
	@OneToOne(cascade=CascadeType.PERSIST)
	public Dept dept;//교수의 학과 정보를 저장하고 있는 객체
	
	public Professor() {
		super();
	}

	
	
	public Long getProfno() {
		return profno;
	}



	public void setProfno(Long profno) {
		this.profno = profno;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getUserid() {
		return userid;
	}



	public void setUserid(String userid) {
		this.userid = userid;
	}



	public String getPosition() {
		return position;
	}



	public void setPosition(String position) {
		this.position = position;
	}



	


	public Long getSal() {
		return sal;
	}



	public void setSal(Long sal) {
		this.sal = sal;
	}



	public Date getHiredate() {
		return hiredate;
	}



	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}



	public String getComm() {
		return comm;
	}



	public void setComm(String comm) {
		this.comm = comm;
	}



	public Dept getDept() {
		return dept;
	}



	public void setDept(Dept dept) {
		this.dept = dept;
	}



	@Override
	public String toString() {
		return "Professor [profno=" + profno + ", name=" + name + ", userid="
				+ userid + ", position=" + position + ", sal=" + sal
				+ ", hiredate=" + hiredate + ", comm=" + comm + ", dept="
				+ dept + "]";
	}
	
	
	
	
	
}
