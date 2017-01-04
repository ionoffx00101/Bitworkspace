package bitjava.year2016.day02;

public class Prob04_1
{
	public static boolean isPrimeNumber(int num)
	{
		int count = 0;

		for (int i = 1; i <= num; i++)
		{
			if (num % i == 0)
			{
				count++;
			}
			if (count == 2)
			{
				return true;
			} else
			{
				return false;
			}

		}
		return false;
	}

	public static void main(String[] args)
	{
		for (int i = 0; i <= 100; i++)
		{
			if ((isPrimeNumber(i)))
			{
				System.out.println("¼Ò¼ö");
			}
		}

	}

}