package Additional;
import java.util.Scanner;

// 2017-01-19 (THU)
/********************************* 
����11.

1���� N������ ���� �̾ ���� ������ ���� ���ο� ���ڸ� ��´�.
12345678910111213...

�̷��� ������� ���ο� ���� �� �ڸ� ������ ���Ͽ� ���.

�Է� : 13
��� : 17

�Է� : 120
��� : 252
***************************************/
public class AdditionalProb11 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("�Է� : ");
		int num = kb.nextInt();
		
		String str = "";
		for(int i=1; i<=num; i++) str += i;
		
		System.out.println("��� : " + str.length());
	}

}
