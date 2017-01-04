package bitjava.year2016.day01;

public class Prob3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	int count3 = 0;
		int counthap = 0;
		while (count3 <= 1000) {
			++count3;
			if (count3 % 2 == 0 && count3 % 7 == 0) {
				System.out.print(count3+ " ");
				counthap = count3 + counthap;
			}
		}
		System.out.println();
		System.out.println("while : " + counthap);*/
		
		int i=1;
		int sum=0;
		while(i<=1000){
			if(i%2==0 && i%7==0){
				System.out.println(i);
				sum+=i;
			}
			i++;
		}
		System.out.println("sum : "+sum);
	}

}
