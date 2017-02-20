package com.bitacademy.mvc;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component("counter04")
@SessionScope // 한 세션에서만 객체 공유함, 사용자1만 쓰고 사용자2만 객체 쓰고 그런 식임
public class MyCounter04 implements IMyCounter
{
	private long num;
	
	// 생성자 오버라이딩
	public MyCounter04()
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
		return "MyCounter04 [num=" + num + ", toString()=" + super.toString() + "]";
	}
}
