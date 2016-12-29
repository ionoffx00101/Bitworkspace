package bitjava.day4;

import java.util.Scanner;

// 배열{3,5,7,11,13,17,19}의 특정 요소를 제거하는 코드를 작성
public class ArrayEx04
{
	public static void showAll(int[] num)
	{
		for (int i = 0; i < num.length; i++)
		{
			System.out.print(num[i] + "	");
		}
	}

	public static void main(String[] args)
	{
		int[] num = { 3, 5, 7, 11, 13, 17, 19 };
		int numDelete;
		Scanner sc = new Scanner(System.in);
		int[] result = new int[num.length - 1];

		showAll(num);
		System.out.println();
		System.out.print("지울 숫자 입력 : ");
		numDelete = sc.nextInt();
		
		//int count 말고 다른 방법이 있을것같다.
		int count=0;
		//제거
		for (int i = 0; i < num.length; i++)
		{
			if (num[i] == numDelete)
			{
				++count;
			}
			else if(num[i] != numDelete){
				result[i-count]=num[i];

			}
		}

		showAll(result);

	}

}
