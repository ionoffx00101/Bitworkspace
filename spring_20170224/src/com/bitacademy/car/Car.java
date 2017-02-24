package com.bitacademy.car;

public class Car
{
	private String ccode;
	private String cname;
	
	public Car(String ccode, String cname)
	{
		super();
		this.ccode = ccode;
		this.cname = cname;
	}

	public Car()
	{
		super();
	}

	public String getCcode()
	{
		return ccode;
	}

	public void setCcode(String ccode)
	{
		this.ccode = ccode;
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
		return "Car [ccode=" + ccode + ", cname=" + cname + "]";
	}
}
