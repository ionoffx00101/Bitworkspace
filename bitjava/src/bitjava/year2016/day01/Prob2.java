package bitjava.year2016.day01;

public class Prob2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*int count2 = 0;
		while (count2 < 100) {
			System.out.print(++count2 + " ");
		}
		System.out.println();
		do {
			System.out.print(count2-- + " ");
		} while (count2 > 0);
		System.out.println();
		System.out.println();*/
		
		
		int i=0;
		while(i++<100){
			System.out.print(i);
		}
		i=100;
		do{
			System.out.print(i);
		}while(i-->1);
	}
}
