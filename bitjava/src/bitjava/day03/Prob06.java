package bitjava.day03;

import java.util.Scanner;

public class Prob06
{
	//.compareTo() ���ڿ� ��
	//.compareToIngnoreCase() ���ڿ� ���ϵ� ��/�ҹ��� ���о���
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("���ڿ� 1 �Է� : ");
		String str1 = scanner.nextLine();
		System.out.print("���ڿ� 2 �Է� : ");
		String str2 = scanner.nextLine();

		if (str1.compareToIgnoreCase(str2) < 0)
		{
			System.out.print("���ڿ� 1 ��");
		} else if (str1.compareToIgnoreCase(str2) > 0)
		{
			System.out.print("���ڿ� 2 �� : ");
		} else
		{
			System.out.print("�� �� ���� ");
		}
	}

}
