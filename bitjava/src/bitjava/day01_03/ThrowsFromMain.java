package bitjava.day01_03;

import java.util.Scanner;

public class ThrowsFromMain
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

	public static void main(String[] args) throws Exception
	{
		System.out.println("���� �Է� ��");
		int age = readAge();
		System.out.println(age + "��");
		
	}

}

/*class AgeInputException extends Exception
{
	public AgeInputException()
	{
		super("��ȿ���� ���� ���̰� �Էµ�");
	}
}*/