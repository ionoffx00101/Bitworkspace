package bitjava.day01_17;

import java.util.ArrayList;
import java.util.Scanner;

public class AdditionalProb09_indexOf
{

	public static void main(String[] args)
	{
		/*
		 * Scanner kb = new Scanner(System.in);
		 * System.out.print("�Է� : ");
		 * String strInput = kb.nextLine();
		 */

		String strInput = ":-) �ູ�ϴ� ���ູ�ϴ� :-) �װ� �ƹ��� ���� :-(  ::";

		int happy = 0;
		int unhappy = 0;

		if(strInput.indexOf(":-)")!=-1){
			System.out.println("�ູ��");
			happy++;
		}
		if(strInput.indexOf(":-(")!=-1){
			System.out.println("���ູ��");
			unhappy++;
		}
		/*�߰ߵǸ� �ű⼭ ���ڿ� ���� �� �ں��� �ٽ� �˻��ؾ��ϳ�
		���� ����Լ���?*/
				
		
		
		System.out.println(happy+"	"+unhappy);
		//
		/*if (happy > unhappy)
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
		}*/

	}

}
//���� 9
//:-) ������
//:-( ������ ��
//		
//		chatAt()
//		indexOf()