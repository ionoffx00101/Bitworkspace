package bitjava.day01_03;

import java.util.Scanner;

public class DivideByZero
{

	public static void main(String[] args)
	{
		System.out.println("�� ���� ���� �Է� : ");
		Scanner kb = new Scanner(System.in);
		int num1 = kb.nextInt();
		int num2 = kb.nextInt();

		try
		{
			System.out.println("������ : " + (num1 / num2));
			System.out.println("������ : " + (num1 % num2));
		} catch (ArithmeticException e)
		{
			System.out.println("������ �Ұ���");
			System.out.println(e.getMessage());

		}
		System.out.println("���α׷� ����");
	}

}
