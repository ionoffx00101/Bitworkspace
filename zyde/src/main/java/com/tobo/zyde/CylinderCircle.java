package com.tobo.zyde;

public class CylinderCircle
{

	public static void main(String[] args)
	{
		Circle circle = new Circle();
		circle.r=6;
		Cylinder cylinder = new Cylinder();
		cylinder.h=5;
		System.out.println(cylinder.Cylinder());
	}

}
class Circle{
	int r;

	public int Circle()
	{
		return (int) (r*r*Math.PI);
	}
	
	
}
class Cylinder{
	Circle c;
	int h;

	public int Cylinder()
	{
		return c.Circle()*h;
	}
}