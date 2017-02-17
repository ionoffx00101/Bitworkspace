package com.bitacademy.professor.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_professor04")
public class Professor
{
	@Id
	private Long profno;
	private String name;
	private Long sal;
	private Long comm;
	private java.sql.Date hiredate;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="deptno",referencedColumnName="deptno")
	private Dept dept;
	private String userid;
	
	public Long getProfno()
	{
		return profno;
	}
	public void setProfno(Long profno)
	{
		this.profno = profno;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Long getSal()
	{
		return sal;
	}
	public void setSal(Long sal)
	{
		this.sal = sal;
	}
	public Long getComm()
	{
		return comm;
	}
	public void setComm(Long comm)
	{
		this.comm = comm;
	}
	public java.sql.Date getHiredate()
	{
		return hiredate;
	}
	public void setHiredate(java.sql.Date hiredate)
	{
		this.hiredate = hiredate;
	}
	public Dept getDept()
	{
		return dept;
	}
	public void setDept(Dept dept)
	{
		this.dept = dept;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	
	@Override
	public String toString()
	{
		return "Professor [profno=" + profno + ", name=" + name + ", sal=" + sal + ", comm=" + comm + ", hiredate=" + hiredate + ", dept=" + dept + ", userid=" + userid + "]";
	}
}
