package bitjava.day01_04;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorUsage
{

	public static void main(String[] args)
	{
		LinkedList<String> list = new LinkedList<String>();
		list.add("First");
		list.add("Firse");
		list.add("Firss");
		list.add("Firsx");
		list.add("Firsc");

		Iterator<String> itr = list.iterator();

		System.out.println("�ݺ��ڸ� �̿��� ��°� \"Firss\" ����");

		while (itr.hasNext())
		{
			String curStr = itr.next();
			System.out.println(curStr);
			if (curStr.compareTo("Firsx") == 0)
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