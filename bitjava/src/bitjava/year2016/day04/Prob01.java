package bitjava.year2016.day04;

public class Prob01
{

	public static void main(String[] args)
	{
		//2차원 배열 생성
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
		
		// 뒤집기
		// int[][] copyarr=arr.clone();
		// if(copyarr[0]!=arr[0]) System.out.println("참조값이 다름."); // shallow copy.
		
        // 2차원 배열 복사
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
		
		
		// 프린트용
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
