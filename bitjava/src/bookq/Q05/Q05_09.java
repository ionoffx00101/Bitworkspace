package bookq.Q05;

public class Q05_09
{

	public static void main(String[] args)
	{
		char[][] star = { { '*', '*', ' ', ' ', ' ' }, { '*', '*', ' ', ' ', ' ' }, { '*', '*', '*', '*', '*' }, { '*', '*', '*', '*', '*' } };
		char[][] result = new char[star[0].length][star.length];
		for (int i = 0; i < star.length; i++)
		{
			for (int j = 0; j < star[i].length; j++)
			{
				System.out.print(star[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < star.length; i++)
		{
			for (int j = 0; j < star[i].length; j++)
			{
				result[i][j] =star[star[i].length-i][star.length-j]; //star[star.length-1-i][star[i].length-j];
			}
		}
		for (int i = 0; i < result.length; i++)
		{
			for (int j = 0; j < result[i].length; j++)
			{
				System.out.print(result[i][j]);
			}
			System.out.println();
		}
	} // end of main
} // end of class