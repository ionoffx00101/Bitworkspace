package com.chaitea.vo;

public class Actor
{
	private String actorname;

	public String getActorname()
	{
		return actorname;
	}

	public void setActorname(String actorname)
	{
		this.actorname = actorname;
	}

	@Override
	public String toString()
	{
		return "Actor [actorname=" + actorname + "]";
	}

}
