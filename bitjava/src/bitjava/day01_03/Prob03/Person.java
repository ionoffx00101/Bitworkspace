package bitjava.day01_03.Prob03;

public class Person
{
	private String name;
	private String address;

	public static void main(String[] args)
	{
	}

	public Person(String name, String address)
	{
		this.name = name;
		this.address = address;
	}

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getName()
	{
		return name;
	}

	@Override
	public String toString()
	{
		return name + "( " + address + " )";
	}

}
