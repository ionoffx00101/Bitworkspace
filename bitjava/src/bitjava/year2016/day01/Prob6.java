package bitjava.year2016.day01;

public class Prob6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int count = 0;
	/*	while (true) {
			if (count % 2 == 1 || (count % 2 == 0 && count % 3 == 0)) {
				sum += count;

				if (sum > 1000) {
					System.out.println("���� : " + sum);
					break;
				}
			}
			count++;
		}*/
		while (true) {
			if ((count % 2 == 0 && count % 3 == 0) || count % 2 == 1) {
				sum += count;

				if (sum > 1000) {
					System.out.println("���� : " + sum);
					break;
				}
			}
			count++;
		}
	}

}
