package bitjava.day3;

public class ClassMethod
{

	public static void main(String[] args)
	{
		NumberPrinter.showInt(20);

		NumberPrinter np = new NumberPrinter();
		np.showDouble(3.15); // 스태틱이 불필요하다는 것이다.. 흠 둘중하나 선택하든지 스태틱 붙인거는 위에처럼 클래스.참조변수?로 하는게 이득이다
	}

}

class NumberPrinter
{
	public static void showInt(int n) //static 붙이면 다른 클래스에서 생성자 호출?안해도 호출 할 수 있다
	{
		System.out.println(n);
	}

	public static void showDouble(double n)
	{
		System.out.println(n);
	}
}