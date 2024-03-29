package bitjava.day01_02;

public class MultiInheritance
{

	public static void main(String[] args)
	{
		IPTV iptv = new IPTV();
		iptv.on();

		TV tv = iptv;
		Computer com = iptv;
	}
}

/*
 * class TV
 * {
 * public void showTV()
 * {
 * System.out.print("영상 출력");
 * }
 * }
 */
interface TV
{
	public void showTV();
}

/*
 * class Computer{
 * public void dataReceive(){
 * System.out.print("영상 데이터 수신");
 * }
 * }
 */
interface Computer
{
	public void dataReceive();
}

class IPTV implements TV, Computer
{
	public void dataReceive()
	{
		System.out.print("영상 데이터 수신");
	}

	public void showTV()
	{
		System.out.print("영상 출력");
	}

	public void on()
	{
		dataReceive();
		showTV();
	}
}