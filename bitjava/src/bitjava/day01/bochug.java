package bitjava.day01;

public class bochug {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = 0;
		int count = 0;
		while (count < 99) {
			++count;
			result = count + result;
		}
		System.out.println(result);
	
		//
		
		int count2 = 0;
		while (count2 < 100) {
			System.out.print(++count2 + " ");
		}
		System.out.println();
		do {
			System.out.print(count2-- + " ");
		} while (count2 > 0);
		System.out.println();
		System.out.println();
		
		//
		
		int ihap = 0;
		for (int i = 0; i <= 1000; i++) {
			if (i % 2 == 0 && i % 7 == 0) {
				ihap = i + ihap;
			}
		}
		System.out.println("for : " + ihap);

		int count3 = 0;
		int counthap = 0;
		while (count3 <= 1000) {
			++count3;
			if (count3 % 2 == 0 && count3 % 7 == 0) {
				System.out.print(count3+ " ");
				counthap = count3 + counthap;
			}
		}
		System.out.println();
		System.out.println("while : " + counthap);
	}

}
