package bitjava.year2016.day03;

import java.util.Scanner;

public class Prob08
{

	public static void main(String[] args)
	{
		String str = "Bit Big Bonet Ball Bow Boder";
		System.out.println("문자열 ㄱ : ");
		Scanner sc = new Scanner(System.in);
		String str2 = sc.nextLine();
		
		System.out.println(
			str.contains(str2) ? "있음" : "없음"	
		);
	}

}
