package bitjava.year2016.day04;

public class ParticallyFilledArray
{

	public static void main(String[] args)
	{
		int[][] arr =
		{
		{ 1, 2 },
		{ 3, 4, 5 },
		{ 6, 7, 8 } 
		};
		System.out.println("�迭�� ���α��� : " + arr.length);
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println((i + 1) + "���� ���� : " + arr[i].length);
		}
	}

}
