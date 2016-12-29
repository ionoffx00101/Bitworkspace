package bitjava.day4;

import java.util.Scanner;

// 숫자 1개를 입력받아 주어진 배열{3,5,7,11,13,17,19}에 해당 숫자가 존재하는지 판단하여 결과 출력
public class ArrayEx03
{

	public static void main(String[] args)
	{
		int[] num = { 3, 5, 7, 11, 13, 17, 19 };
		Scanner sc = new Scanner(System.in);
		int numFind;

		//입력
		System.out.println("숫자입력하세요");
		numFind = sc.nextInt();

		//정렬
		boolean bResult = false;
		for (int i = 0; i < num.length; i++)
		{
			if (num[i] == numFind)
			{
				bResult = true;
			}
		}

		//출력
		if (!bResult)
		{
			System.out.println("없다");
		} else
		{
			System.out.println("있다");
		}
	}

}
