package bitjava.day01_17;

import java.util.ArrayList;
import java.util.Scanner;

public class AdditionalProb09
{

	public static void main(String[] args)
	{
		/*
		 * Scanner kb = new Scanner(System.in);
		 * System.out.print("�Է� : ");
		 * String strInput = kb.nextLine();
		 */

		String strInput = ":-) �ູ�ϴ� ���ູ�ϴ� :-( :() :-(�װ� �ƹ��� ���� :-(  ::";

		int happy = 0;
		int unhappy = 0;

		ArrayList<String> arrayStr = new ArrayList<String>();

		for (int i = 0; i <= strInput.length() - 1; i++)
		{
			char ch = strInput.charAt(i);
			if (ch == ':')
			{

				//System.out.println("ã��");

				if (strInput.length() - i > 2)// �ذ��� �� / ������ĭ�� : ���� ������ �ذ��� ����� �����غ� 
				{

					//-�� ������ ����ϳ� ã�°� ����� ������ ���� ������ �� ���� �����ϱ� ������
					char chx = strInput.charAt(i + 1);
					if (chx == '-')
					{
						char chy = strInput.charAt(i + 2);
						if (chy == ')')
						{
							//System.out.println("����");
							happy++;
						} else if (chy == '(')
						{
							//System.out.println("��");
							unhappy++;
						}
					}
				}

			}

		}

		//
		System.out.println(happy+"	"+unhappy);
		if (happy > unhappy)
		{
			System.out.println("�ູ��");
		} else if (happy < unhappy)
		{
			System.out.println("���ູ��");
		} else if (happy == unhappy)
		{
			System.out.println("�Ȱ���");
		} else if (happy == 0 & unhappy == 0)
		{
			System.out.println("���� ����");
		}

	}

}
//���� 9
//:-) ������
//:-( ������ ��
//		
//		chatAt()
//		indexOf()