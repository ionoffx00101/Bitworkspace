package com.bitacademy.synchronize.non;

public class MyArray
{
	private int[] arr = new int[20]; // 최대 크기 설정
	private int index = 0;
	private int num = 0;

	//synchronized
	public boolean push(String thread, int sleeptime) throws Throwable
	{
		if (index < arr.length)
		{
			arr[index] = num;
			System.out.println(thread + "push:arr[" + index + "]=" + num); // 뭔지 알기위해 출력해본다
			Thread.sleep(sleeptime); // 너무 빠르니까 잠깐 재우자
			index++;
			num++;
			return true;
		}
		else
		{
			return false;
		}
	}
}
