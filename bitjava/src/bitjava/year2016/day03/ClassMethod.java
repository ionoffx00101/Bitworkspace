package bitjava.year2016.day03;

public class ClassMethod
{

	public static void main(String[] args)
	{
		NumberPrinter.showInt(20);

		NumberPrinter np = new NumberPrinter();
		np.showDouble(3.15); // ����ƽ�� ���ʿ��ϴٴ� ���̴�.. �� �����ϳ� �����ϵ��� ����ƽ ���ΰŴ� ����ó�� Ŭ����.��������?�� �ϴ°� �̵��̴�
	}

}

class NumberPrinter
{
	public static void showInt(int n) //static ���̸� �ٸ� Ŭ�������� ������ ȣ��?���ص� ȣ�� �� �� �ִ�
	{
		System.out.println(n);
	}

	public static void showDouble(double n)
	{
		System.out.println(n);
	}
}