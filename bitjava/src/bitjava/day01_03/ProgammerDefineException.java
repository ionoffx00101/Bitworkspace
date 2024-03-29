package bitjava.day01_03;

import java.util.Scanner;

public class ProgammerDefineException
{
	public static int readAge() throws AgeInputException
	{
		Scanner kb = new Scanner(System.in);
		int age = kb.nextInt();
		if (age < 0)
		{
			AgeInputException exc = new AgeInputException();
			throw exc;
		}
		return age;
	}

	public static void main(String[] args)
	{
		System.out.println("나이 입력 ㄱ");
		try
		{
			int age = readAge();
			System.out.println(age + "살");
		} catch (AgeInputException e)
		{
			System.out.println(e.getMessage());
		}
	}

}

class AgeInputException extends Exception
{
	public AgeInputException()
	{
		super("유효하지 않은 나이가 입력됨");
	}
}