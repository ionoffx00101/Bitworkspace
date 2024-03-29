package bitjava.day01_05;

public class ThreadSyncError
{

	public static void main(String[] args)
	{
		Increment inc = new Increment();
		IncThread it1 = new IncThread(inc);
		IncThread it2 = new IncThread(inc);
		IncThread it3 = new IncThread(inc);

		it1.start();
		it2.start();
		it3.start();

		try
		{
			it1.join();
			it2.join();
			it3.join();

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println(inc.getNum());
	}

}

class Increment
{
	int num = 0;
	
	// public void Increment() 동기화가 안 됨
	public synchronized void Increment()  // synchronized 동기화..
	{
		num++; //둘이상의 쓰레드가 이문장을 동시에 실행하면서 문제 발생;;;;;;;;;;;
	}

	public int getNum()
	{
		return this.num;
	}

}

class IncThread extends Thread
{
	Increment inc;

	public IncThread(Increment inc)
	{
		this.inc = inc;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				inc.Increment();
			}
		}
	}

}
