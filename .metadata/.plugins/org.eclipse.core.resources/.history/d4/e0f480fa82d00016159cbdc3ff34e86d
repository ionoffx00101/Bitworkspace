package bitjava.day4;

public class Prob01_1
{
	// 다른 클래스에서 작업하도록함
	public static int[][] changeArr(int[][] arr)
	{
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
					arr[i][j] = copyarr[i-(arr.length-1)][j];
				}
				else{
					arr[i][j] = copyarr[i+1][j];
				}
			}
		}
		return arr;
	}

	public static void main(String[] args)
	{
		//2차원 배열 생성
		int[][] arr = new int[4][4];
		int num = 0;
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j < arr[i].length; j++)
			{
				num += 1;
				arr[i][j] = num;

			}
		}
		arr=changeArr(arr);

		// 프린트용
		for (int i = 0; i < arr.length; i++)
		{
			for (int j = 0; j <arr[i].length; j++)
			{
				System.out.print(arr[i][j] + "	"); //System.out.print(arr[i][j] +"	"+i+" "+j+"	");
			}
			System.out.println();
		}
	}

}
