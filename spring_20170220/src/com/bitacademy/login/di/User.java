package com.bitacademy.login.di;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component("loginUser")
public class User
{
	private String id;
	private String pw;

	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
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
		return "User [id=" + id + ", pw=" + pw + ", toString()=" + super.toString() + "]";
	}
	

}
