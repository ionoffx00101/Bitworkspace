package bitjava.year2016.day03;

public class Prob13
{
//.replace(char,char)
	public static void main(String[] args)
	{
		String str = "Bit Bit Bit Bi t asdwelx well done crap";
		
		for (int i = 0; i < str.length(); i++)
		{
			str = str.replace(str.charAt(i),'_');
		}

		System.out.print(str);
	}

}
