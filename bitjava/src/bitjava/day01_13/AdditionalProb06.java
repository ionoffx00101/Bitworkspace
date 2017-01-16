package bitjava.day01_13;

import java.util.Scanner;

/* 2017-01-13 (FRI) 
자바 문제6. palindrome

앞에서부터 읽었을 때와 뒤로부터 읽었을 때 똑같은 문자열(ex. LOL, NOON)을 만들어 주는 코드를 작성. (단, 결과 문자열은 가장 짧게.)

입력 : bit
출력 : bitib
*/

public class AdditionalProb06 {
	public static String strInput;  // 두 글자 이상.
	public static String strOutput;
	
	public static boolean isPalindrome(String strArg) {
		boolean result = true;
		String str;
		str = strArg;
		while(str.length()>1) {
			if( (str.charAt(0) != str.charAt(str.length()-1)) ) {
				result = false;
			} 
			str = str.substring( 0+1 , str.length()-1 );
		}
		
		return result;
	}
	public static void append(int start) {
		for(int k=strInput.length()-start; k>=0; k--) {
			strOutput += strInput.charAt(k); 
		}
	}
	public static void main(String[] args) {
		// 입력
		Scanner kb = new Scanner(System.in);
		System.out.print("입력 : ");
		strInput = kb.nextLine();
		strOutput = strInput;
		
		// 팰린드롬 체크 / 연산
		if(isPalindrome(strInput)) {
			// 끝.
		} else {
			for(int i=0; i<=strInput.length()-1; i++) {
				if(isPalindrome(strInput.substring(i))) {
					append(strInput.length()-i+1);
					break;
				}
			}
		}
		
		// 결과출력
		System.out.println("결과 : " + strOutput);
	}

}
