package bitjava.day01_05;

public class PriorityTestOne
{

	public static void main(String[] args)
	{
		MessageSnedingThread mst = new MessageSnedingThread("First");
		MessageSnedingThread mst2 = new MessageSnedingThread("sdasd");
		MessageSnedingThread mst3 = new MessageSnedingThread("aksdks");

		mst.start();
		mst2.start();
		mst3.start();
	}

}

class MessageSnedingThread extends Thread
{

	String msg;

	//	int priority;

	public MessageSnedingThread(String str)
	{

		msg = str;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			System.out.println(msg + " " + getPriority());
		}

	}
}