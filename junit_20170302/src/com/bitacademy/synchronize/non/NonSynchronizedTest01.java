package com.bitacademy.synchronize.non;

public class NonSynchronizedTest01
{
	public static void main(String[] args)
	{
		MyArray myArray = new MyArray();
		
		MyThread01 mythread01 = new MyThread01(myArray);
		MyThread02 mythread02 = new MyThread02(myArray);
		
		mythread01.start(); // MyThread01 시작
		mythread02.start(); // MyThread02 시작
		
	}
}
