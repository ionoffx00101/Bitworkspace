package bitjava.year2016.day02;

public class Prob05
{
	public static void main(String[] args)
	{
		System.out.println(ee(5));

	}

	public static int ee(int n)
	{
		if (n == 1)
		{
			return 2;
		} else
		{
			return 2*ee(n-1);
		}

	}
}
