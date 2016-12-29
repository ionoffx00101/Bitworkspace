package bookq.Q05;

public class Q05_10
{

	public static void main(String[] args)
	{
		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[', ']', '{', '}', ';', ':', ',',
				'.', '/' };
		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		String src = "abc123";
		String result = "";
		// src charAt() result 문자열 의 문자를 으로 하나씩 읽어서 변환 후 에 저장
		for (int i = 0; i < src.length(); i++)
		{
			char ch = src.charAt(i);

			if (122 >= ch && ch >= 97)
			{

				int num = src.indexOf(ch);
				result += abcCode[num];

			} else if (57 >= ch && ch >= 48)
			{

				int num = ch; //48 49 50
				result += numCode[num-48];

			}
		}
		System.out.println("src:" + src);
		System.out.println("result:" + result);
	} // end of main
} // end of class
