package bitjava.day01_16;

import java.util.ArrayList;
import java.util.Scanner;

// 2017-01-16(MON)
// ����8. ���� �ߺ� ó�� / ��ǥ(,) ��ħǥ(.) ó��.
// �Է� : ���ڿ� (I   am,    a      java programmer.)
// ��� : 5�� / reverse : programmer java a am I
public class AdditionalProb08_1 {

	public static void main(String[] args) {
		//String strInput = "I   am,    a      java programmer.";
		// �Է�
		Scanner kb = new Scanner(System.in);
		System.out.print("�Է� : ");
		String strInput = kb.nextLine();
		
		ArrayList<String> arrayStr = new ArrayList<String>();
		String s = "";
		for(int i=0; i<=strInput.length()-1; i++) {
			char ch = strInput.charAt(i);
			if(ch==' ' || ch==',' || ch=='.') {
				if(s.length()>0) {   // s�� ���ڿ��� �ִ� ���¿��ٸ�, arraylist�� add.
					arrayStr.add(s);
					s="";
				}
			}
			else {
				s += ch;
			}
		}
		
		System.out.print("��� : " + arrayStr.size());
		System.out.print(" / reverse : ");
		for(int i=arrayStr.size()-1; i>=0; i--)
			System.out.print(arrayStr.get(i) + " ");
		
	}

}
