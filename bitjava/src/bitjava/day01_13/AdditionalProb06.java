package bitjava.day01_13;

import java.util.Scanner;

/* 2017-01-13 (FRI) 
�ڹ� ����6. palindrome

�տ������� �о��� ���� �ڷκ��� �о��� �� �Ȱ��� ���ڿ�(ex. LOL, NOON)�� ����� �ִ� �ڵ带 �ۼ�. (��, ��� ���ڿ��� ���� ª��.)

�Է� : bit
��� : bitib
*/

public class AdditionalProb06 {
	public static String strInput;  // �� ���� �̻�.
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
		// �Է�
		Scanner kb = new Scanner(System.in);
		System.out.print("�Է� : ");
		strInput = kb.nextLine();
		strOutput = strInput;
		
		// �Ӹ���� üũ / ����
		if(isPalindrome(strInput)) {
			// ��.
		} else {
			for(int i=0; i<=strInput.length()-1; i++) {
				if(isPalindrome(strInput.substring(i))) {
					append(strInput.length()-i+1);
					break;
				}
			}
		}
		
		// ������
		System.out.println("��� : " + strOutput);
	}

}
