package com.bitacademy.user;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_user")
public class User
{
	@Id
	private String id;
	private String name;
	private String nickname;
	private String pw;
	
	public User()
	{
		super();
	}
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getNickname()
	{
		return nickname;
	}
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
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
		return "User [id=" + id + ", name=" + name + ", nickname=" + nickname + ", pw=" + pw + "]";
	}
}
