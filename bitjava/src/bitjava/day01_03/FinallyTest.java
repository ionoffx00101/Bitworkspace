package bitjava.day01_03;

public class FinallyTest
{

	public static void main(String[] args)
	{
		boolean divOK = divider(4, 2);
		if(divOK){
			System.out.println("실행");
		}
		else{
			System.out.println("실패");
		}
		System.out.println("");
		divOK = divider(4, 0);
		if(divOK){
			System.out.println("실행");
		}
		else{
			System.out.println("실패");
		}

	}
public static boolean divider(int num1,int num2)
{
	try
	{
		int result = num1/num2;
		System.out.println(result);
		return true;
	} catch (Exception e)
	{
		System.out.println(e.getMessage());
		return false;
	}
	finally{
		System.out.println("finally 실행");
	}
}
}
