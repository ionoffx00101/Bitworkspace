package bitjava.day01_19;

import java.util.Scanner;

public class AdditionalProb12
{

	public static void main(String[] args)
	{
		String[] strInput = null;
		int numInput;
		int count = 0;

		Scanner kb = new Scanner(System.in);
		System.out.println("입력 (단어 개수/ 단어들)");
		numInput = kb.nextInt();

		kb = new Scanner(System.in);// 객체 다시 초기화
		// todo sth
		strInput = new String[numInput];
		for (int i = 0; i <= numInput - 1; i++)
		{
			strInput[i] = kb.nextLine();
			if (isGroupWord(strInput[i]))
			{
				count++;
			}
		}
	}

	public static boolean isGroupWord(String str)
	{
		for (int i = 0; i < str.length(); i++)
		{
			if(str.indexOf(str.charAt(i),i+1)>0){
				if(str.indexOf(str.charAt(i),i+1)-i>0){
					return false;
				}
			}
		}
		return true;
	}

}
