package bitjava.day01_06;

public class SyncNewsPaper
{

	public static void main(String[] args)
	{
		NewsPaper paper = new NewsPaper();
		NewsReader reader1 = new NewsReader(paper);
		NewsReader reader2 = new NewsReader(paper);
		NewsWriter writer = new NewsWriter(paper);

		reader1.start();
		reader2.start();

		try
		{
			Thread.sleep(1000);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		writer.start();

		try
		{
			reader1.join();
			reader2.join();
			writer.join();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}

class NewsPaper
{
	String todayNews;
	boolean isTodayNews = false;

	public void setTodayNews(String news)
	{
		todayNews = news;
		isTodayNews = true;

		notifyAll(); // ������ ��� �����
	}

	public String getTodayNews()
	{
		if (!isTodayNews)
		{
			try
			{
				synchronized (this)
				{
					wait();
				}
				
			} catch (Exception e)
			{
				e.printStackTrace();
			}

		}
		return todayNews;
	}
}

class NewsWriter extends Thread
{
	NewsPaper paper;

	public NewsWriter(NewsPaper paper)
	{

		this.paper = paper;

	}

	@Override
	public void run()
	{
		paper.setTodayNews("��� ���� ���� ����");
	}
}

class NewsReader extends Thread
{
	NewsPaper paper;

	public NewsReader(NewsPaper paper)
	{

		this.paper = paper;

	}

	@Override
	public void run()
	{
		System.out.println("������ ���� : " + paper);
	}
}