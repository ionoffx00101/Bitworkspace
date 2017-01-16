package bitjava.day01_12;

import java.util.Scanner;
import java.util.Stack;

//2017-01-12(THU) 문제1.
//16진수 변환기 (DO NOT USE 재귀적(recursive) 호출)

public class AdditionalProb04 {
	
	public static String toHex(int num) {
		String strOutput = "";
		Stack<Integer> stack = new Stack<Integer>();
		while(num>0) {
			stack.add(num%16);
			num = num/16;
		}
		while(!stack.isEmpty()) {
			int n = stack.pop();
			strOutput += (char)((n>=10) ? ((n-10)+'A') : (n+'0'));
		}
		return strOutput;
	}
	
	public static void main(String[] args) {
		// 입력
		Scanner kb = new Scanner(System.in);
		System.out.print("10진수 입력 : ");
		String strInput = kb.nextLine();
		
		// 변환
		String strOutput = toHex(Integer.parseInt(strInput) );
		
		// 출력
		System.out.println(strOutput + " (16진수)");
	}

}
