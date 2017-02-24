package com.bitacademy.cus;

public class Customer
{
	private String userid;
	private String name;
	private String pw;

	public Customer()
	{
		super();
	}

	public Customer(String userid, String name, String pw)
	{
		super();
		this.userid = userid;
		this.name = name;
		this.pw = pw;
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
	public String getPw()
	{
		return pw;
	}
	public void setPw(String pw)
	{
		this.pw = pw;
	}

	@Override
	public String toString()
	{
		return "Customer [userid=" + userid + ", name=" + name + ", pw=" + pw + "]";
	}
}
