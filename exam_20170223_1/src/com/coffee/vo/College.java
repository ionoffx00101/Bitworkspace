package com.coffee.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_COLLEGE20170220")
public class College
{
	@Id
	private Long colno;
	private String cname;
	
	
	public College()
	{
		super();
	}
	public Long getColno()
	{
		return colno;
	}
	public void setColno(Long colno)
	{
		this.colno = colno;
	}
	public String getCname()
	{
		return cname;
	}
	public void setCname(String cname)
	{
		this.cname = cname;
	}
	
	@Override
	public String toString()
	{
		return "College [colno=" + colno + ", cname=" + cname + "]";
	}
}
