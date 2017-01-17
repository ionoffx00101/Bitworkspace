package bitjava.day01_09;

import java.util.Scanner;

public class AdditionalProb01
{
	public static final boolean SHOW_PROGRESS = false;

	public static void main(String[] args)
	{
		// �Է�
		Scanner kb = new Scanner(System.in);
		System.out.println("���ȣ �Է�");
		int roomNum = 0;
		while (true)
		{
			roomNum = kb.nextInt();
			if (roomNum >= 1 && roomNum <= 1000 * 1000)
			{
				break;
			}
			System.out.println("�ٽ� �Է�");
		}
		
		//
		int[] arrNumCount = new int[10];
		String strNum = "" + roomNum;
		for (int i = 0; i < strNum.length(); i++)
		{
			int nowNum = strNum.charAt(i) - '0';
			arrNumCount[nowNum]++;
		}
		
		//�ʿ��� ��ƼĿ ���� ���
		int maxNum = 0;
		arrNumCount[6] += arrNumCount[9];
		arrNumCount[9] = 0;
		for (int i = 0; i <= 9; i++)
		{
			if (i != 6 && i != 9 && arrNumCount[i] > maxNum)
			{
				maxNum = arrNumCount[i];
			} else
			{
				if (arrNumCount[i] / 2.0f > maxNum)
				{
					maxNum = Math.round(arrNumCount[i] / 2.0f);
				}
			}
		}
		
		//��� ���
		System.out.println();
		System.out.println(maxNum);
	}
}