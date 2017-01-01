package bookq.Q06;

public class Q06_07
{

	public static void main(String args[])
	{
		MyPoint p = new MyPoint(1, 1);
		// p (2,2) . 와 의 거리를 구한다
		System.out.println(p.getDistance(2, 2));
	}
}

class MyPoint
{
	int x;
	int y;

	MyPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public double getDistance(int x2,int y2){
		
		double result = Math.sqrt(Math.abs((x - x2)*(x - x2)+(y - y2)*(y - y2)));
		return result;
	}
}
