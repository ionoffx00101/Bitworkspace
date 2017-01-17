package bitjava.day01_16;

import java.util.ArrayList;
import java.util.Scanner;

// 2017-01-16(MON)
// 문제8. 띄어쓰기 중복 처리 / 쉼표(,) 마침표(.) 처리.
// 입력 : 문자열 (I   am,    a      java programmer.)
// 출력 : 5개 / reverse : programmer java a am I
public class AdditionalProb08_1 {

	public static void main(String[] args) {
		//String strInput = "I   am,    a      java programmer.";
		// 입력
		Scanner kb = new Scanner(System.in);
		System.out.print("입력 : ");
		String strInput = kb.nextLine();
		
		ArrayList<String> arrayStr = new ArrayList<String>();
		String s = "";
		for(int i=0; i<=strInput.length()-1; i++) {
			char ch = strInput.charAt(i);
			if(ch==' ' || ch==',' || ch=='.') {
				if(s.length()>0) {   // s에 문자열이 있는 상태였다면, arraylist에 add.
					arrayStr.add(s);
					s="";
				}
			}
			else {
				s += ch;
			}
		}
		
		System.out.print("출력 : " + arrayStr.size());
		System.out.print(" / reverse : ");
		for(int i=arrayStr.size()-1; i>=0; i--)
			System.out.print(arrayStr.get(i) + " ");
		
	}

}
