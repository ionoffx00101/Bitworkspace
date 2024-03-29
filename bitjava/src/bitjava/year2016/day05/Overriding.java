package bitjava.year2016.day05;

public class Overriding
{

	public static void main(String[] args)
	{
		BaseEnSpeaker bs = new BaseEnSpeaker();
		bs.setVolume(10);
		bs.setBaseRate(20);
		bs.showCurrentState();
	}

}

class Speaker
{
	private int volumeRate;

	public void showCurrentState()
	{
		System.out.println(volumeRate);
	}

	public void setVolume(int vol)
	{
		volumeRate = vol;
	}
}

class BaseEnSpeaker extends Speaker
{
	private int baseRate;

	@Override //다른 개발자들을 위해 넣어주는 것이지..
	public void showCurrentState() //오버라이딩 해서 재정의 하는 것이다
	{
		super.showCurrentState();
		System.out.println(baseRate);
	}

	public void setBaseRate(int base)
	{
		baseRate = base;
	}
}