package bitjava.day01_10;

import java.util.ArrayList;
import java.util.Scanner;

public class Prob01
{

	public static void main(String[] args)
	{
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		Scanner kb = new Scanner(System.in);

		//�Է�
		System.out.println("1 : ");
		int num1 = kb.nextInt();
		System.out.println("2 : ");
		int num2;

		while (true)
		{
			num2 = kb.nextInt();
			if (num2 >= 0 && num2 <= 9)
			{
				break;
			}
			System.out.println("again");
		}

		//���ڸ� ������ ���ڸ� �ľ��ؼ� ����Ʈ�� �߰�
		String strNum1 = "" + num1;
		int count = 0;
		for (int i = 0; i < strNum1.length(); i++)
		{
			if (strNum1.charAt(i) == num2 + '0')
			{
				String strShort = strNum1.substring(0, i) + strNum1.substring(i + 1);
				count++;
				arrList.add(Integer.parseInt(strShort));
			}
		}

		//�ִ밪 ���
		int maxNum = 0;
		for (int i = 0; i < count; i++)
		{
			if (maxNum < arrList.get(i))
			{
				maxNum = arrList.get(i);
			}
		}
		System.out.println("maxNum : " + maxNum);
	}
}
//arraylist, integerParse 