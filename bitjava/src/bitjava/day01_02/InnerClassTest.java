package bitjava.day01_02;

public class InnerClassTest
{

	public static void main(String[] args)
	{
		OuterClass out1 = new OuterClass("First");
		OuterClass out2 = new OuterClass("Second");
		out1.whoAreYou();
		out2.whoAreYou();

		OuterClass.InnerClass inn1 = out1.new InnerClass();
		OuterClass.InnerClass inn2 = out2.new InnerClass();
		OuterClass.InnerClass inn3 = out1.new InnerClass();
		OuterClass.InnerClass inn4 = out1.new InnerClass();
		OuterClass.InnerClass inn5 = out2.new InnerClass();

	}

}

class OuterClass
{
	private String myName;
	private int num;

	OuterClass(String name)
	{
		myName = name;
		num = 0;

	}

	public void whoAreYou()
	{
		num++;
		System.out.println(myName + "	" + num);
	}

	class InnerClass
	{
		InnerClass()
		{
			whoAreYou();
		}
	}
}
