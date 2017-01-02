package bitjava.day3;

import java.util.Scanner;

public class Prob05
{

	public static void main(String[] args)
	{
		String one = "안녕하하하하세요 이게게 됩니까까";
		//
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자 입력 : ");
		String in = scanner.nextLine();
		//
		if (in.length() != 1)
		{
			System.out.println("너무 많이 입력함");
			return;//종료
		}
		//
		char c = in.charAt(0);
		int count = 0;
		for (int i = 0; i < one.length(); i++)
		{
			if (one.charAt(i) == c)
			{
				count++;
			}
		}
		//
		System.out.println(count);
	}

}
