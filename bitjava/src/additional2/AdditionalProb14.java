package additional2;

import java.util.Scanner;

// ����14. (2017-01-24 ȭ)
// ��.
public class AdditionalProb14 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("�Է� : ");
		int num = kb.nextInt();
		
		for(int i=1; i<=num; i++) {
			for(int j=1; j<=num-i; j++) System.out.print(" ");
			System.out.print("*");
			if(i==1) { System.out.println(); continue; }
			if(i<num) for(int j=1; j<=(i-2)*2+1; j++) System.out.print(" ");
			else for(int j=1+1; j<=num*2-1-1; j++) System.out.print("*");
			System.out.print("*");
			System.out.println();
		}
		
	}

}

