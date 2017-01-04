package bitjava.day01_04.Prob01;

public class LineSub extends Point
{
	private Point begin;
	private Point end;

	public static void main(String[] args)
	{

	}

	public LineSub(int x1, int y1, int x2, int y2)
	{
		super(x1, y1);
		this.end = new Point(x2, y2);
	}

	public LineSub(Point begin, Point end)
	{
		super(begin.getX(), begin.getY());
		this.end = end;
	}

	public Point getBegin()
	{
		return (Point) this;
	}

	public void setBegin()
	{
		super.setX(begin.getX());
		super.setY(begin.getY());
	}

	public Point getEnd()
	{
		return end;
	}

	public void setEnd(Point end)
	{
		this.end = end;
	}

	//EndXY
	public int[] getEndXY()
	{
		return end.getXY();
	}

	public void setEndXY(int x, int y)
	{
		end.setXY(x, y);
	}

	public double getLength()
	{
		return super.distance(end);

	}

	@Override
	public String toString()
	{
		return "LineSub [begin=(" + getX() + " " + getY() + ")" + ",end=(" + getX() + " " + getY() + ")]";
	}

}
