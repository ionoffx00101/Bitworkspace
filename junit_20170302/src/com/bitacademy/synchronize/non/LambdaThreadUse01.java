package com.bitacademy.synchronize.non;

public class LambdaThreadUse01
{
	public static void main(String[] args)
	{
		MyArray myArray = new MyArray(); //다른 곳에 만들어둔 클래스인 MyArray를 매개변수로 가지고 있다. 

		Thread mythread01 = new Thread(() ->
		{
			try
			{
				while (true)
				{
					boolean go = myArray.push("MyThread01", 100);

					if (!go) // if(true)여야만 돌아가고 true=!false // go==false
					{
						break;
					}
				}
			}
			catch (Throwable e) // InterruptedException e
			{
				e.printStackTrace();
			}
		});

		Thread mythread02 = new Thread(() ->
		{
			try
			{
				while (true)
				{
					boolean go = myArray.push("MyThread02", 100);

					if (!go) // if(true)여야만 돌아가고 true=!false // go==false
					{
						break;
					}
				}
			}
			catch (Throwable e) // InterruptedException e
			{
				e.printStackTrace();
			}
		});

		mythread01.start(); // MyThread01 시작
		mythread02.start(); // MyThread02 시작

	}
}
