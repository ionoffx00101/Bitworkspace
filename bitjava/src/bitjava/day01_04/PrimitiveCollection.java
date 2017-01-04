package bitjava.day01_04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class PrimitiveCollection
{
	public static void main(String[] args)
	{
		LinkedHashSet<Integer> list = new LinkedHashSet<Integer>();
		list.add(10); //Auto Boxing
		list.add(30); //Auto Boxing
		list.add(45); //Auto Boxing
		list.add(23); //Auto Boxing
		list.add(60); //Auto Boxing

		Iterator<Integer> itr = list.iterator();

		while (itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}
