package bitjava.day01_05;

public class ThreadUnderstand
{

	public static void main(String[] args)
	{
		ShowThread st1 = new ShowThread("Thread1");
		ShowThread st2 = new ShowThread("Thread2");

		st1.start();
		st2.start();
	}

}

class ShowThread extends Thread
{

	String ThreadName;

	public ShowThread(String name)
	{
		ThreadName = name;

	}

	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			System.out.println("Hallo. " + ThreadName + "	" + i);
			try
			{
				sleep(300);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}