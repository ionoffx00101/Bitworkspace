package com.coffee.vo;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_CUSTOMER20170220")
public class Customer
{
	@Id
	private String userid;
	private String name;
	
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="deptno",referencedColumnName="deptno") // (name="내 컬럼",referencedColumnName="니 컬럼")
	private Dept dept;
	
	private Integer pw;
	
	
	public Customer()
	{
		super();
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Dept getDept()
	{
		return dept;
	}
	public void setDept(Dept dept)
	{
		this.dept = dept;
	}
	public Integer getPw()
	{
		return pw;
	}
	public void setPw(Integer pw)
	{
		this.pw = pw;
	}
	
	@Override
	public String toString()
	{
		return "Customer [userid=" + userid + ", name=" + name + ", dept=" + dept + ", pw=" + pw + "]";
	}
}
