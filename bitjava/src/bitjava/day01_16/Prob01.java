package bitjava.day01_16;

import java.util.Scanner;

public class Prob01
{

	public static void main(String[] args)
	{
		/*
		 * Scanner kb = new Scanner(System.in);
		 * String str = kb.nextLine();
		 */
		
		String str = "I am a Java Progammer";
		String[] strArr = new String[str.length()];
		
		// 문자열로 나누기 나눠서 배열에 넣기 근데 배열일까 ㅇ리스트일까 스택일까 그건 모르지 
		
		
	//strArr[2] = str.substring(0,1); 
	
		for (int i = 0; i < strArr.length; i++)
		{
			strArr[i] = str.substring(i,i+1); 
		}
		// 이제 뭐 해야할지 잘 모르겠다 그럼 ㅅㄱ
	System.out.println(strArr[6]);
		
	}

}

/*
 * 문제 8
 * 
 * -- 1단계
 * 입력 문자열 i am a java progammer
 * 출력 5개
 * 문자열 개수 출력 하는것
 * 
 * -- 2단계
 * i am, a java programmer
 * 띄어쓰기 중복처리 쉼표 마침표 처리
 * 
 * -- 3단계 출력 5개 . 역순 출력 까지
 * i am, a java programmer.
 * 
 * 테트리스 구현 1단계 (awt)
 * rotate() 메서드 완성
 * 왼쪽으로 이동 오른쪽으로 이동 시 정확한 검사 로직 추가
 */