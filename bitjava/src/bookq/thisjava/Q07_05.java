package bookq.thisjava;

public class Q07_05
{

	public static void main(String[] args)
	{

	}

}

class Parent
{
	public String name;

	public Parent(String name)
	{
		this.name = name;
	}
}

class Child extends Parent
{
	private int studentNO;

	public Child(String name, int studentNO)
	{
		super(name); // ���� �߰��Ѱ�
		this.name = name;
		this.studentNO = studentNO;
	}
}