package bitjava.day01_04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class UsefulIterator
{

	public static void main(String[] args)
	{
		HashSet<String> list = new HashSet<String>();
		list.add("5");
		list.add("4");
		list.add("2");
		list.add("1");
		list.add("3");

		Iterator<String> itr = list.iterator();

		System.out.println("�ݺ��ڸ� �̿��� ��°� \"Firss\" ����");

		while (itr.hasNext())
		{
			String curStr = itr.next();
			System.out.println(curStr);
			if (curStr.compareTo("2") == 0)
			{
				itr.remove();
			}

		}

		itr=list.iterator(); //�������� itr �����Ͱ� ���� �ǹǷ� �ٽ� �־��ذ��̴�
		while (itr.hasNext())
		{
			System.out.println("������"+itr.next());
		}
	}

}
