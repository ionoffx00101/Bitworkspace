package bitjava.year2016.day04;

public class Prob01
{

	public static void main(String[] args)
	{
		//2���� �迭 ����
		int[][] arr = new int[4][4];
		int num = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				num+=1;
				arr[i][j] = num;

			}
		}
		
		// ������
		// int[][] copyarr=arr.clone();
		// if(copyarr[0]!=arr[0]) System.out.println("�������� �ٸ�."); // shallow copy.
		
        // 2���� �迭 ����
		int[][] copyarr=new int[arr.length][arr[0].length];
		for (int i = 0; i < copyarr.length; i++)
		{
			for (int j = 0; j < copyarr[i].length; j++)
			{
				copyarr[i][j] = arr[i][j];
			}
		}
		
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				if(i==arr.length-1){
					arr[i][j] = copyarr[i-3][j];
				}
				else{
					arr[i][j] = copyarr[i+1][j];
				}
			}
		}
		
		
		// ����Ʈ��
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				System.out.print(arr[i][j] +"	"); //System.out.print(arr[i][j] +"	"+i+" "+j+"	");
			}
			System.out.println();
		}
	}

}
