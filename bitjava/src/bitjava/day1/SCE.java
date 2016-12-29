package bitjava.day1;

public class SCE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0;
		int num2 = 2;
		boolean result;

		result = (num1 += 10) < 0 && (num2 += 10) > 0; //둘다 true 일때만 true 내보냄   && = and 앞에 계산 했을때 이미 false이라 뒤에 num2는 계산 안함
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + ", num2 = " + num2);

		result = (num1 += 10) < 0 || (num2 += 10) > 0; //둘중 한개만 true값을 줘도 true로 내보내줌  || = or
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		int n1=5;
		
		

	}

}
