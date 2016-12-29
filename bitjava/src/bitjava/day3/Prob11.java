package bitjava.day3;

public class Prob11
{
	// 알파벳 인덱스 꺼내기
	// 문자열의 모든 문자의 알파벳 인덱스 번호를 출력하는 코드
	public static void main(String[] args)
	{
		String str = "Bit Bit Bit Bi t asdwelx well done crap";
		for (int i = 0; i <= str.length()-1; i++)
		{
			System.out.println(
					str.toLowerCase().charAt(i)-'a'+1
			);
		}
	}

}
