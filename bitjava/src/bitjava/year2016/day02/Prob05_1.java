package bitjava.year2016.day02;

public class Prob05_1
{
	public static void main(String[] args)
	{
		int n=5;
		System.out.println(myPow(n));

	}

	public static int myPow(int num)
	{
		
		if (num == 0)
		{
			return 1;
		} else
		{
			return 2*myPow(num-1);
		}

	}
}
