package bitjava.day01_05;

public class SyncObjectKey
{

	public static void main(String[] args)
	{
		IHaveTwoNum numInst = new IHaveTwoNum();
		AccessThread at1 = new AccessThread(numInst);
		AccessThread at2 = new AccessThread(numInst);

		at1.start(); //extends Thread한 클래스의 인스턴스를 start();
		at2.start(); //extends Thread한 클래스의 인스턴스를 start();

		try
		{
			at1.join();
			at2.join();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		numInst.showAllNums();
	}

}

class IHaveTwoNum
{
	int num1 = 0;
	int num2 = 0;
	private Object key1; // 뭐지..
	private Object key2;

	public void addOneNum1()
	{
		synchronized (key1)
		{
			num1++;
		}

	}

	public void addTwoNum1()
	{
		synchronized (key1)
		{
			num1 += 2;
		}
		
	}

	public void addOneNum2()
	{
		synchronized (key2)
		{
			num2++;
		}
		
	}

	public void addTwoNum2()
	{
		synchronized (key2)
		{
			num2 += 2;
		}
	
	}

	public void showAllNums()
	{
		System.out.println(num1);
		System.out.println(num2);
	}
}

class AccessThread extends Thread
{
	IHaveTwoNum twoNuminst;

	public AccessThread(IHaveTwoNum inst)
	{
		twoNuminst = inst;
	}

	@Override
	public void run()
	{
		twoNuminst.addOneNum1();
		twoNuminst.addOneNum2();
		twoNuminst.addTwoNum1();
		twoNuminst.addTwoNum2();
	}
}