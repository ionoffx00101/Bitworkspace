package additional2;

import java.util.Scanner;

// 문제14. (2017-01-24 화)
// 별.
public class AdditionalProb14 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("입력 : ");
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

