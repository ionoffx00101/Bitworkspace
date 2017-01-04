package bitjava.day01_03.Prob02;

public class Point3D extends Point2D
{
	int z;

	public static void main(String[] args)
	{
		//2d에서도 3d에서도 실행은 됨;;
		/*Point3D d = new Point3D(4, 2, 6);
		System.out.print(d.toString());*/
	}

	public Point3D()
	{
		super(); //상위클래스의 생성자를 호출 ㅎㅎ
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
