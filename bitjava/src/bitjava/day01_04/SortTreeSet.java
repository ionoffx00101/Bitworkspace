package bitjava.day01_04;

import java.util.Iterator;
import java.util.TreeSet;

public class SortTreeSet
{
	public static void main(String[] args)
	{
		TreeSet<Integer> tree = new TreeSet<Integer>();
		tree.add(1);
		tree.add(3);
		tree.add(2);
		tree.add(5);
		tree.add(4);

		System.out.println("저장된 데이터 크기 : " + tree.size());

		Iterator<Integer> itr = tree.descendingIterator(); // tree.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next());

		}
	}
}
