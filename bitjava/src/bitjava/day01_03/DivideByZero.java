package bitjava.day01_03;

import java.util.Scanner;

public class DivideByZero
{

	public static void main(String[] args)
	{
		System.out.println("두 개의 정수 입력 : ");
		Scanner kb = new Scanner(System.in);
		int num1 = kb.nextInt();
		int num2 = kb.nextInt();

		try
		{
			System.out.println("나눗셈 : " + (num1 / num2));
			System.out.println("나머지 : " + (num1 % num2));
		} catch (ArithmeticException e)
		{
			System.out.println("나눗셈 불가능");
			System.out.println(e.getMessage());

		}
		System.out.println("프로그램 종료");
	}

}
