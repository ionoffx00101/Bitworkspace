package com.bitacademy.synchronize.sync;

public class MyArray
{
	private int[] arr = new int[20]; // 최대 크기 설정
	private int index = 0;
	private int num = 0;

	// synchronized 붙이면 쓰레드끼리 기다려준다.
	// public 앞에 붙이든 뒤에 붙이든 상관 없는듯
	// synchronized 붙은 메소드는 공유객체의 속성 Lock을 점유한 객체만 호출가능
	// Lock 속성은 Object로부터 상속받은 속성
	// Lock lock ?
	public synchronized boolean push(String thread, int sleeptime) throws Throwable
	{
		System.out.println(thread + " try push:arr[" + index + "] = " + num); // 하기 전에 출력
		if (index < arr.length)
		{
			arr[index] = num;

			Thread.sleep(sleeptime); // 너무 빠르니까 잠깐 재우자

			System.out.println(thread + " pushed:arr[" + index + "] = " + num); // 넣고 출력

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
