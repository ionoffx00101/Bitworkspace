package bitjava.day4;

import java.util.Scanner;

// 문자열 4개 입력 받아서 알파벳순으로 정렬
public class ArrayEx02
{

	public static void main(String[] args)
	{
		String[] arr = new String[4];
		Scanner sc = new Scanner(System.in);
		
		System.out.println("문자입력하세요");
		//입력
		for (int i = 0; i <= 3; i++)
		{
			
			arr[i] = sc.nextLine();
		}
		
		//정렬
		for (int i = 0; i <= 2; i++)
		{
			for (int j = i + 1; j <= 3; j++)
			{
				if(arr[i].compareToIgnoreCase(arr[j])>0){
					String temp = arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}

			}
		}
		
		//출력
		System.out.print("입력한 문자는 : ");

		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + "	");
		}
	}

}
