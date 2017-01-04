package bitjava.day01_03.Prob02;

public class Point3D extends Point2D
{
	int z;

	public static void main(String[] args)
	{
		//2d������ 3d������ ������ ��;;
		/*Point3D d = new Point3D(4, 2, 6);
		System.out.print(d.toString());*/
	}

	public Point3D()
	{
		super(); //����Ŭ������ �����ڸ� ȣ�� ����
		this.z = 0;
	}

	public Point3D(int x, int y, int z)
	{
		super(x,y);
		/*setX(x);
		setY(y);*/
		this.z = z;
	}

	public int getZ()
	{
		return z;
	}

	public void setZ(int z)
	{
		this.z = z;
	}

	@Override
	public String toString()
	{
		return "Point3D (" + super.getX() + " , " + super.getY() + " , " + z + ")";
	}

}
