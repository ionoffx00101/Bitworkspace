package bitjava.day01_05;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeMap;

public class IntroTreeMap
{

	public static void main(String[] args)
	{
		TreeMap<Integer, String> tree = new TreeMap<Integer, String>();
		tree.put(1, "data1");
		tree.put(2, "data2");
		tree.put(3, "data3");
		tree.put(4, "data4");
		tree.put(5, "data5");
		tree.put(1, "redata1");

		NavigableSet<Integer> navi = tree.navigableKeySet();  //Ű�����θ� ������ set�� ����

		Iterator<Integer> itr = navi.iterator();  // navi���� iterator�� �̾Ƴ� > ����?
		while (itr.hasNext())  
		{
			System.out.println(tree.get(itr.next()));
		}
	}

}
