package bitjava.day01_18;

import java.util.Scanner;

// 2017-01-18(WED)
// ����10. Anagram.
public class AdditionalProb10_1 {

	// ���ڿ����� �� ���� ����.
	public static String removeOneChar(String str, char c) {
		if(str.indexOf(c)>=0) {
			return str.substring(0, str.indexOf(c)) + str.substring(str.indexOf(c)+1);
		}
		return null;
	}
	// �� �ٿ� �ִ� �ѱ��� ����.
	public static char getCommonChar(String str1, String str2) {
		for(int i=0; i<=str1.length()-1; i++) {
			for(int j=0; j<=str2.length()-1;j++) {
				if(str1.charAt(i) == str2.charAt(j)) return str1.charAt(i);
			}
		}
		return ' ';
	}
	public static void main(String[] args) {
		// �Է�
		Scanner kb = new Scanner(System.in);
		System.out.print("�Է�1 : ");
		String strInput1 = kb.nextLine();
		System.out.print("�Է�2 : ");
		String strInput2 = kb.nextLine();
		String str1 = strInput1;
		String str2 = strInput2;
		
		// �ֳʱ׷� ó��
		while(getCommonChar(str1, str2) != ' ') {
			char chCommon = getCommonChar(str1, str2);
			str1 = removeOneChar(str1, chCommon);
			str2 = removeOneChar(str2, chCommon);
		}
		
		// ���
		System.out.print(strInput1 + " - " + str1 + " = ");
		for(int i=0; i<=str1.length()-1; i++) strInput1 = removeOneChar(strInput1, str1.charAt(i));
		System.out.println(strInput1);
		System.out.print(strInput2 + " - " + str2 + " = ");
		for(int i=0; i<=str2.length()-1; i++) strInput2 = removeOneChar(strInput2, str2.charAt(i));
		System.out.println(strInput2);
		
		System.out.println( "��� : " + (str1.length() + str2.length()) + "���� ���ڸ� �����ϸ� Anagram ����." );
		
	}

}