package bitjava.day01_17;

import java.util.ArrayList;
import java.util.Scanner;

public class AdditionalProb09_indexOf
{

	public static void main(String[] args)
	{
		/*
		 * Scanner kb = new Scanner(System.in);
		 * System.out.print("입력 : ");
		 * String strInput = kb.nextLine();
		 */

		String strInput = ":-) 행복하니 안행복하니 :-) 그건 아무도 모르지 :-(  ::";

		int happy = 0;
		int unhappy = 0;

		if(strInput.indexOf(":-)")!=-1){
			System.out.println("행복함");
			happy++;
		}
		if(strInput.indexOf(":-(")!=-1){
			System.out.println("안행복함");
			unhappy++;
		}
		/*발견되면 거기서 문자열 끊고 그 뒤부터 다시 검사해야하나
		설마 재귀함수각?*/
				
		
		
		System.out.println(happy+"	"+unhappy);
		//
		/*if (happy > unhappy)
		{
			System.out.println("행복함");
		} else if (happy < unhappy)
		{
			System.out.println("안행복함");
		} else if (happy == unhappy)
		{
			System.out.println("똑같음");
		} else if (happy == 0 & unhappy == 0)
		{
			System.out.println("감정 없음");
		}*/

	}

}
//문제 9
//:-) 개수랑
//:-( 개수를 비교
//		
//		chatAt()
//		indexOf()