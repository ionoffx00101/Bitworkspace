package bitjava.day03;

import java.util.Scanner;

public class Prob07
{

	public static void main(String[] args)
	{
		String str = "bit Big good args string";

		Scanner kb = new Scanner(System.in);
		System.out.print("���ڿ� �Է��� : ");
		String str2 = kb.nextLine();
		System.out.println(str.concat(str2));
		System.out.println(str + str2);
	}

}
