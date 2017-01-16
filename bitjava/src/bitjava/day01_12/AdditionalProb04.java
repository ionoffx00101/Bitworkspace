package bitjava.day01_12;

import java.util.Scanner;
import java.util.Stack;

//2017-01-12(THU) ����1.
//16���� ��ȯ�� (DO NOT USE �����(recursive) ȣ��)

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
		// �Է�
		Scanner kb = new Scanner(System.in);
		System.out.print("10���� �Է� : ");
		String strInput = kb.nextLine();
		
		// ��ȯ
		String strOutput = toHex(Integer.parseInt(strInput) );
		
		// ���
		System.out.println(strOutput + " (16����)");
	}

}
