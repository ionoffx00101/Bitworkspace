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
			System.out.println("������ �Է� : ");
			int num1 = kb.nextInt();

			System.out.println("���� �Է� : ");
			int num2 = kb.nextInt();

			if (num2 == 0)
			{
				System.out.print("������ 0�� �ɼ� ����");
				i -= 1;
				continue;
			}

			int idx = kb.nextInt();

			if (idx < 0 || idx > 99)
			{
				System.out.println("��ȿ���� ���� �ε���");
				i--;
				continue;
			}

			arr[idx] = num1 / num2;

			System.out.println("������ ��� :" + arr[idx]);
			System.out.println("����� �ε��� ��ġ" + idx);
		}
	}

}
