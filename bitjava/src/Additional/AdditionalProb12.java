package Additional;
import java.util.Scanner;

// 2017-01-19(THU)
/*********************************
문제12.

"그룹단어"란, 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서만 나타나는 경우를 말한다.
예를 들어, aacczzzzbb는 a,c,z,b가 모두 연속해서만 나타나고, kiz는 k,i,z가 모두 연속해서만 나타나기 때문에 "그룹단어"이지만, abbbcccb는 b가 떨어져서 나타나기 때문에 "그룹단어"가 아니다.

첫째 줄에 단어의 개수 N을 입력으로 받은 후 N개 만큼의 단어를 입력 받아서, "그룹단어"의 개수를 출력.

입력 : 
4
feel
so
good
servlet
출력 :
3
**********************************/
public class AdditionalProb12 {
	public static boolean isGroupWord(String str) {
		for(int i=0; i<=str.length()-1; i++) {
			if(str.indexOf(str.charAt(i), i+1)>0) {
				if( str.indexOf(str.charAt(i), i+1) - i > 1 ) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
//		System.out.println(isGroupWord("feel"));
//		System.out.println(isGroupWord("so"));
//		System.out.println(isGroupWord("good"));
//		System.out.println(isGroupWord("servlet"));
		String[] strInput = null;
		int numInput;
		int count = 0;
		
		Scanner kb = new Scanner(System.in);
		System.out.print("입력(단어 개수 / 단어들) : ");
		numInput = kb.nextInt();
		
		kb = new Scanner(System.in);
		strInput = new String[numInput];
		for(int i=0; i<=numInput-1; i++) {
			//System.out.print(i);
			strInput[i] = kb.nextLine();
			if(isGroupWord(strInput[i])) count++;
		}
		
		System.out.println("결과 : " + count);
	}

}
