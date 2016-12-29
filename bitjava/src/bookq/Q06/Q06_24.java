package bookq.Q06;

public class Q06_24
{

	public static void main(String[] args)
	{
		int value=5;
		System.out.println(value+"의 절대값 : "+abs(value));
		value=-10;
		System.out.println(value+"의 절대값 : "+abs(value));
		
	}
	public static int abs(int a){
		
		
		return Math.abs(a);
	}
}
