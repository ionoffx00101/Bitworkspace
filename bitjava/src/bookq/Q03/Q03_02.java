package bookq.Q03;

public class Q03_02
{

	public static void main(String[] args)
	{
		int num = 123;
		int size = 10;
		int numofbucket = (num / size) + (num % size >= 1 ? 1 : 0);

		System.out.println(numofbucket);

	}

}
