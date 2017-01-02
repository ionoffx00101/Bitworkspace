package bitjava.day03;

import java.util.Scanner;

public class Prob06
{
	//.compareTo() 문자열 비교
	//.compareToIngnoreCase() 문자열 비교하되 대/소문자 구분없이
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열 1 입력 : ");
		String str1 = scanner.nextLine();
		System.out.print("문자열 2 입력 : ");
		String str2 = scanner.nextLine();

		if (str1.compareToIgnoreCase(str2) < 0)
		{
			System.out.print("문자열 1 승");
		} else if (str1.compareToIgnoreCase(str2) > 0)
		{
			System.out.print("문자열 2 승 : ");
		} else
		{
			System.out.print("둘 다 같아 ");
		}
	}

}
