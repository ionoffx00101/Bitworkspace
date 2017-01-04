package bitjava.year2016.day03;

public class Prob17
{
//스트링 클래스의 chatAt()사용하는 방법이랑 StringBuolder 클래스를 이용하는 방법
	public static void main(String[] args)
	{
		String str = "1234567890ABCDEFG";
		StringBuilder sb = new StringBuilder(str);
		//1)
		for (int i = str.length() - 1; i >= 0; i--)
		{
			System.out.print(str.charAt(i));
		
		}
		System.out.println();
		//2)
		/*
		 * 내가 푼 방법 sb.chatAt으로 위에 string이용하듯 이용했다.
		 * for (int i = sb.toString().length() - 1; i >= 0; i--)
		{
			System.out.print(sb.charAt(i));		
		}*/
		System.out.print(sb.reverse());  //stringbuilder에 reverse함수가 있다.
		
	}

}
