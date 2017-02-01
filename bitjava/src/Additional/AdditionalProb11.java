package Additional;
import java.util.Scanner;

// 2017-01-19 (THU)
/********************************* 
문제11.

1부터 N까지의 수를 이어서 쓰면 다음과 같이 새로운 숫자를 얻는다.
12345678910111213...

이렇게 만들어진 새로운 수는 몇 자리 수인지 구하여 출력.

입력 : 13
출력 : 17

입력 : 120
출력 : 252
***************************************/
public class AdditionalProb11 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = kb.nextInt();
		
		String str = "";
		for(int i=1; i<=num; i++) str += i;
		
		System.out.println("결과 : " + str.length());
	}

}
