package bitjava.day01_04;

import java.util.HashSet;
import java.util.Iterator;

class SimpleNumber
{
	int num;

	public SimpleNumber(int a)
	{
		num = a;
	}

	public String toString()
	{
		return String.valueOf(num);
	}
//hashsetEqulity two에서 추가된 부분
	public int hashCode()
	{
		return num % 3;
	}

	@Override
	public boolean equals(Object obj)
	{
		SimpleNumber comp = (SimpleNumber) obj;
		if (comp.num == num)
			return true;
		else return false;

	}
}

public class HashSetEqualityOne
{
	public static void main(String[] args)
	{
		HashSet<SimpleNumber> hset = new HashSet<SimpleNumber>();
		hset.add(new SimpleNumber(5));
		hset.add(new SimpleNumber(15));
		hset.add(new SimpleNumber(64));
		hset.add(new SimpleNumber(24));
		hset.add(new SimpleNumber(3));
		hset.add(new SimpleNumber(64));

		System.out.println(hset.size());
		Iterator<SimpleNumber> itr = hset.iterator();
		while (itr.hasNext())
		{
			System.out.println(itr.next());

		}
	}
}