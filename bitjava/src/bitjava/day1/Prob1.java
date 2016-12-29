package bitjava.day1;

public class Prob1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i=1;
		int sum=0;
		
		while (i<=99) {
			sum+=i;
			i++;
		}
		System.out.println("гу"+sum);
		//
		int result = 0;
		int count = 0;
		while (count < 99) {
			++count;
			result = count + result;
		}
		System.out.println(result);
	}
}
