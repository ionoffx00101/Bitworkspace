package bitjava.day3;

public class StringMethod
{

	public static void main(String[] args)
	{
		String str1= "d";
		String str2= "a";
		String str3= "w";
		String str4= "s";
		String str5= str1.concat(str2).concat(str3);
		
		System.out.println(str5);
		System.out.println(str5.length());
		
		if(str1.compareTo(str3)<3){
			System.out.println("str1이 앞서감");
			
		}
		else if (str1.compareTo(str3)<0){
			System.out.println("str1이 안감");
		}
	}

}
