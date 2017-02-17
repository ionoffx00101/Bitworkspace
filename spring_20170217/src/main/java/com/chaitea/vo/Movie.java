package com.chaitea.vo;

public class Movie
{
	private Long num;
	private String name;
	private Actor actor;
	private java.sql.Date openDate;
	
	public Long getNum()
	{
		return num;
	}
	public void setNum(Long num)
	{
		this.num = num;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Actor getActor()
	{
		return actor;
	}
	public void setActor(Actor actor)
	{
		this.actor = actor;
	}
	public java.sql.Date getOpenDate()
	{
		return openDate;
	}
	public void setOpenDate(java.sql.Date openDate)
	{
		this.openDate = openDate;
	}
	
	@Override
	public String toString()
	{
		return "Movie [num=" + num + ", name=" + name + ", actor=" + actor + ", openDate=" + openDate + "]";
	}

}
