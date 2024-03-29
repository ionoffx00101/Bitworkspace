package bitjava.day01_03.Prob02;

public class Point2D
{
	private int x;
	private int y;

	public static void main(String[] args)
	{
		Point3D d = new Point3D(4, 2, 6);
		System.out.print(d.toString());
	}

	/*
	 * public void Point()
	 * {
	 * 
	 * }
	 * public void Point(int x, int y)
	 * {
	 * 
	 * }
	 */

	public Point2D()
	{
		this.x = 0;
		this.y = 0;
	}

	public Point2D(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	@Override
	public String toString()
	{
		return "Point2D (" + x + " , " + y + ")";
	}

}
