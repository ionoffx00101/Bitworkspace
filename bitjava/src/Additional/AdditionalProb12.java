package Additional;
import java.util.Scanner;

// 2017-01-19(THU)
/*********************************
����12.

"�׷�ܾ�"��, �ܾ �����ϴ� ��� ���ڿ� ���ؼ�, �� ���ڰ� �����ؼ��� ��Ÿ���� ��츦 ���Ѵ�.
���� ���, aacczzzzbb�� a,c,z,b�� ��� �����ؼ��� ��Ÿ����, kiz�� k,i,z�� ��� �����ؼ��� ��Ÿ���� ������ "�׷�ܾ�"������, abbbcccb�� b�� �������� ��Ÿ���� ������ "�׷�ܾ�"�� �ƴϴ�.

ù° �ٿ� �ܾ��� ���� N�� �Է����� ���� �� N�� ��ŭ�� �ܾ �Է� �޾Ƽ�, "�׷�ܾ�"�� ������ ���.

�Է� : 
4
feel
so
good
servlet
��� :
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
		System.out.print("�Է�(�ܾ� ���� / �ܾ��) : ");
		numInput = kb.nextInt();
		
		kb = new Scanner(System.in);
		strInput = new String[numInput];
		for(int i=0; i<=numInput-1; i++) {
			//System.out.print(i);
			strInput[i] = kb.nextLine();
			if(isGroupWord(strInput[i])) count++;
		}
		
		System.out.println("��� : " + count);
	}

}
