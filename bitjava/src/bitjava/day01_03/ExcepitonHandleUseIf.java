package bitjava.day01_03;

import java.util.Scanner;

public class ExcepitonHandleUseIf
{

	public static void main(String[] args)
	{
		Scanner kb = new Scanner(System.in);
		int[] arr = new int[100];

		for (int i = 0; i < 3; i++)
		{
			System.out.println("피제수 입력 : ");
			int num1 = kb.nextInt();

			System.out.println("제수 입력 : ");
			int num2 = kb.nextInt();

			if (num2 == 0)
			{
				System.out.print("제수는 0이 될수 없음");
				i -= 1;
				continue;
			}

			int idx = kb.nextInt();

			if (idx < 0 || idx > 99)
			{
				System.out.println("유효하지 않은 인덱스");
				i--;
				continue;
			}

			arr[idx] = num1 / num2;

			System.out.println("나눗셈 결과 :" + arr[idx]);
			System.out.println("저장된 인덱스 위치" + idx);
		}
	}

}
