package bitjava.year2016.day02;

public class Prob06_1
{

	public static void main(String[] args)
	{
		int n=26;
		System.out.print(n+"�� 2������ ");
		myToBinary(n);

	}

	public static void myToBinary(int num)
	{
		
		if (num == 0)
		{
			return ; //void���� ��ȯ�ϴ� ���� ���� �ϰ� ������ return ���� �ȴ�.
		} else
		{
			myToBinary(num/2);
			System.out.print(num%2);
		}

	}

}
