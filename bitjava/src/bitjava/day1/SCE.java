package bitjava.day1;

public class SCE {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1 = 0;
		int num2 = 2;
		boolean result;

		result = (num1 += 10) < 0 && (num2 += 10) > 0; //�Ѵ� true �϶��� true ������   && = and �տ� ��� ������ �̹� false�̶� �ڿ� num2�� ��� ����
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + ", num2 = " + num2);

		result = (num1 += 10) < 0 || (num2 += 10) > 0; //���� �Ѱ��� true���� �൵ true�� ��������  || = or
		System.out.println("result = " + result);
		System.out.println("num1 = " + num1 + ", num2 = " + num2);
		
		int n1=5;
		
		

	}

}
