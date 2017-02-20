package com.bitacademy.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component("counter03")
@RequestScope // 요청할 때마다 아래 속성을 기반으로 매번 새로운 객체를 만들어서 리턴해주세요
public class MyCounter03 implements IMyCounter
{
	private long num;
	
	// 생성자 오버라이딩
	public MyCounter03()
	{
		System.out.println("객체 새로 만듬 ㅇㅇ");
	}
	
	
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
		return "MyCounter03 [num=" + num + ", toString()=" + super.toString() + "]";
	}
}
