package bitjava.year2016.day03;

public class ClassVar //대표 클래스 ㅎㅎ..
{

	public static void main(String[] args)
	{
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
	}

}

class InstCnt
{
	static int instNum = 0; // int instNum = 0; 

	public InstCnt()
	{
		instNum++;
		System.out.println(instNum);
	}
}