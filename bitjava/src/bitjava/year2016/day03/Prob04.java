package bitjava.year2016.day03;

import java.util.Scanner;

public class Prob04
{

	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		String in = "�ȳ��ϼ��� �̰� �˴ϱ�?";
		System.out.print("���� �Է� : ");
		int n = scanner.nextInt()-1;
		System.out.println(in.substring(0,n+1));
	}

}
