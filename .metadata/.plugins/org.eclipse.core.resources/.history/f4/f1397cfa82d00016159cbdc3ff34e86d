package bitjava.day4;

// 두개의 이차원을 합치기
public class ArrayEx06
{
	public static void showAll(int[][] num)
	{
		for (int i = 0; i < num.length; i++)
		{
			for (int j = 0; j < num[i].length; j++)
			{
				System.out.print(num[i][j] + "	");
			}
			System.out.println("");
		}
		System.out.println("");
	}

	public static void main(String[] args)
	{
		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] arr2 = { { 4, 5, 6 }, { 7, 8, 9 }, { 1, 2, 3 } };
		int[][] result = new int[arr1.length][arr1[0].length * 2];

		//기존 배열 출력
		showAll(arr1);
		showAll(arr2);

		//결합
		for (int i = 0; i<arr1.length; i++)
		{
			for (int j = 0; j < arr1[0].length * 2; j++)
			{
				if (j < arr1[0].length)
				{
					result[i][j] = arr1[i][j];
				} else
				{
					result[i][j] = arr2[i][j-arr1[0].length];
				}
			}
		}
		showAll(result);

	}

}
