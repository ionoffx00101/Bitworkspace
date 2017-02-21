package com.bitacademy.test;

import java.util.HashMap;

import org.junit.Test;

import com.bitacademy.vo.Good;

public class GoodTest3
{

	@Test
	public void test()
	{
		
		// HashMap<K,V>
		HashMap<Good, String> hash = new HashMap<>(); // 이게 되는 문법이라는 게 너무너무 신기하다
		
		hash.put(new Good(1L, "갤럭시4", 10000L, 4L, "san", null), "020");
		hash.put(new Good(2L, "갤5", 6400L, 2L, "as", null), "203");
		hash.put(new Good(3L, "갤2", 1730L, 5L, "xnzn", null), "534");
		hash.put(new Good(4L, "갤1", 1120L, 1L, "ner", null), "645");
		
		// search용 Good객체를 만든다
		Good serchgood = new Good();
		serchgood.setGnum(2L);
		
		// 키를 이용해서 찾는다 
		System.out.println(hash.get(serchgood));
	}

}
