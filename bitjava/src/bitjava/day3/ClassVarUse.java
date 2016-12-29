package bitjava.day3;

public class ClassVarUse
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Circle c1 = new Circle(1.2);
		c1.showPerimeter();
		c1.showArea();
	}

}

class Circle
{
	static final double PI = 3.1415; //최종객체이니 final을 붙여주자 다같이 공유하는 것이니 static을 붙여주자
	double radius;

	public Circle(double rad)
	{
		radius = rad;

	}

	public void showPerimeter()
	{
		double peri = (radius * 2) * PI;
		System.out.println("둘레 " + peri);
	}

	public void showArea()
	{
		double area = (radius * radius) * PI;
		System.out.println("넓이 " + area);
	}
}
