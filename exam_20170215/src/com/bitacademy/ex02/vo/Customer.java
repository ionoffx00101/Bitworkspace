package com.bitacademy.ex02.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_customer3")
public class Customer
{
	@Id // 밑에 속성이 테이블에서는 pk이랑 연결되는 아이입니다!
	String id; // private
	@Column(name="password")
	String pw;
	String name;
	String address;
	String phone;

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
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	@Override
	public String toString()
	{
		return "Customer [id=" + id + ", pw=" + pw + ", name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}

}
