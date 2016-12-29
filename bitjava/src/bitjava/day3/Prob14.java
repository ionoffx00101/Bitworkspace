package bitjava.day3;

import java.util.Scanner;

public class Prob14
{

	public static void main(String[] args)
	{
		String str = "Bit Bit Bit Bi t asdwelx well done crap";
		
		Scanner kb= new Scanner(System.in);
		String strStart=kb.nextLine();
		
		System.out.print(str.startsWith(strStart)?"주어진 문자열로 시작":"ㄴㄴ");
	}

}
