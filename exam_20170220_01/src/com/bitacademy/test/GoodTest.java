package com.bitacademy.test;

import java.util.ArrayList;

import org.junit.Test;

import com.bitacademy.vo.Good;

public class GoodTest
{

	@Test
	public void test()
	{
		ArrayList<Good> goodList = new ArrayList<Good>();
		goodList.add(new Good(1L, "갤럭시4", 10000L, 4L, "san", null));
		goodList.add(new Good(2L, "갤럭시7", 750000L, 3365L, "rrt", null));
		goodList.add(new Good(3L, "갤럭시2", 19000L, 25L, "sns", null));

		Good newGood = new Good();
		newGood.setGnum(2L);

		// goodList에서 newGood과 같은 걸 해당 객체 위치 반환 0부터임
		int searchIndex = goodList.indexOf(newGood);
		System.out.println(searchIndex);
		System.out.println(goodList.get(searchIndex));
	}

}
