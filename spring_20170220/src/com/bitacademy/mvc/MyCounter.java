package com.bitacademy.mvc;

import org.springframework.stereotype.Component;

@Component("counter")
public class MyCounter
{
	public String getCounter(String controllerName)
	{
		String msg = "<h1>" + controllerName + "</h1>";
		msg += "<h3>counter = " + this + "</h3>";
		// 지역 변수로 num 선언
		long num = 0;
		for (int i = 0; i < 10; i++)
		{
			msg += "<h3>num = " + ++num + "</h3>";
		}
		return msg;
	}

	// private long num;
	//
	// public long getNum() {
	// return num;
	// }
	//
	// public void setNum(long num) {
	// this.num = num;
	// }
	//
	// @Override
	// public String toString() {
	// return "MyCounter [num=" + num + ", hashCode()=" + hashCode() + "]";
	// }

}
