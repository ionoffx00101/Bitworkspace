package bitjava.day01_04;

import java.util.Iterator;
import java.util.TreeSet;

public class ComparablePerson
{

	public static void main(String[] args)
	{
		TreeSet<Person> tree = new TreeSet<Person>();
		tree.add(new Person("A", 5));
		tree.add(new Person("B", 46));
		tree.add(new Person("E", 65));
		tree.add(new Person("T", 15));

		Iterator<Person> itr = tree.iterator();
		while (itr.hasNext())
		{
			itr.next().showData();
		}

	}

}

class Person implements Comparable<Person>
{
	String name;
	int age;

	public Person(String name, int age)
	{
		this.name = name;
		this.age = age;

	}

	public void showData()
	{
		System.out.println(name + "	" + age);
	}

	@Override
	public int compareTo(Person p)
	{
		/*
		 * if (age > p.age)
		 * {
		 * return 1;
		 * } else if (age < p.age)
		 * {
		 * return -1;
		 * } else
		 * {
		 * return 0;
		 * }
		 */
		return age - p.age;
	}
}