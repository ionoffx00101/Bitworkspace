package com.bitacademy.test;

import java.util.HashMap;

import org.junit.Test;

public class GoodTest2
{

	@Test
	public void test()
	{
		// HashMap<K,V>
		HashMap<String, String> hash = new HashMap<>(); // <String,String> 꼭 써야하는 걸까?
		hash.put("홍길동", "020");
		hash.put("마우스", "203");
		hash.put("모니터", "534");
		hash.put("키보드", "645");
		
		// 키를 이용해서 찾는다 
		System.out.println(hash.get("모니터"));
	}

}
