package bitjava.year2016.day02;

public class Prob06
{
	public static void main(String[] args)
	{
		recall(4);
	}

	public static int recall(int n)
	{
		/*if (n == 1)
		{
		//	System.out.println(((n-1)/2%3)==0 ? 1 :0);
			return n;
		} else
		{
			System.out.print((((n)/2)%2)==0 ? 0 : 1);
			return recall(n-n/2);
		}*/
		if (n%2==0)
		{
			System.out.println("n��"+n);
			System.out.println(((n/2)%2)==0 ? 1 : 0+" ");
			
			return recall(n-n/2)+n%2;
		}
		if(n==2)
		{
			System.out.print(1+"d ");
			return n;
		}
		else if(n==1)
		{
			System.out.print(0+"c ");
			return n;
		}
		return n;

	}
}
