package bookq.Q05;

public class Q05_11
{

	public static void main(String[] args)
	{
		int[][] score = { { 100, 100, 100 }, { 20, 20, 20 }, { 30, 30, 30 }, { 40, 40, 40 }, { 50, 50, 50 } };
		int[][] result = new int[score.length + 1][score[0].length + 1];

		for (int i = 0; i < score.length; i++)
		{

			for (int j = 0; j < score[i].length; j++)
			{
				result[i][j] = score[i][j];
				if (j + 1 == score[i].length)
				{
					int hap = 0;
					for (int k = 0; k < score[k].length; k++)
					{
						hap += score[i][k];
					}
					result[i][j + 1] = hap;
				}
				
				
				
			}
			//세로 더하기 
			for (int k = 0; k < result[i].length; k++)
			{
				int hap=0;
				for (int h = 0; h < score.length; h++)
				{
					hap+=result[h][k];
				}
				result[score.length][k]=hap;
			}

		}
		for (int i = 0; i < result.length; i++)
		{
			for (int j = 0; j < result[i].length; j++)
			{
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}
	} // main
}