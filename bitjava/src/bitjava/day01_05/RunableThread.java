package bitjava.day01_05;

public class RunableThread
{

	public static void main(String[] args)
	{
		AdderThread at = new AdderThread(1, 50);
		AdderThread at2 = new AdderThread(51, 100);
		Thread tr1 = new Thread(at);
		Thread tr2 = new Thread(at2);

		tr1.start();
		tr2.start();

		try
		{
			System.out.println("--");
			tr1.sleep(1000);
			tr1.join(); // 해당 쓰레드가 종료될때까지 프로그램 실행을 멈춤.

			System.out.println("==");
			tr2.sleep(1000);
			tr2.join(); // 해당 쓰레드가 종료될때까지 프로그램 실행을 멈춤.

			System.out.println("~~");

		} catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		System.out.println("1~100 result : " + (at.getNum()) + (at2.getNum()));
	}

}

class Sum
{
	int num;

	public Sum()
	{
		num = 0;
	}

	public void addNum(int n)
	{
		num += n;
	}

	public int getNum()
	{
		return num;
	}

}

class AdderThread extends Sum implements Runnable
{
	int start, end;

	public AdderThread(int start, int end)
	{
		this.start = start;
		this.end = end;
	}

	@Override
	public void run()
	{
		for (int i = start; i <= end; i++)
		{
			addNum(i);
			System.out.println("  "+i);
		}
		
	}

}