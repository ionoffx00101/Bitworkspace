package bitjava.day01_05;

import java.util.HashMap;

public class IntroHashMap
{

	public static void main(String[] args)
	{
		// HashMap<K, V> 
		HashMap<Integer, String> hMap = new HashMap<Integer, String>();
		hMap.put(new Integer(3), "Three");
		hMap.put(5, "Five");
		hMap.put(7, "Seven");
		
		hMap.put(7, "Seven2");
		hMap.put(new Integer(5), "Five2");
		
		System.out.println("size : " + hMap.size());
		System.out.println("5 : " + hMap.get(5));
		System.out.println("7 : " + hMap.get(7));
		System.out.println("3 : " + hMap.get(3));

		hMap.remove(5);
		System.out.println("5 : " + hMap.get(5));
	}

}
