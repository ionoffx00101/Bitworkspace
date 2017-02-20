package com.bitacademy.mvc;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("counter02")
@Scope("prototype") // 컨트롤러마다 다른 걸 씀 같은 컨트롤러내에서만 공유해라
public class MyCounter02 implements IMyCounter
{
	private long num;
	
	@Override
	public void setNum(long num)
	{
		this.num = num;
	}

	@Override
	public long getNum()
	{
		return num;
	}

	@Override
	public String toString()
	{
		return "MyCounter02 [num=" + num + ", toString()=" + super.toString() + "]";
	}
}
