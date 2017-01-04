package bitjava.day03;

public class ClassVarAccess
{

	public static void main(String[] args)
	{
		AccessWay way = new AccessWay();
		way.num++; //++
		AccessWay.num++; //++
		System.out.println(AccessWay.num); //++ 
	}

}

class AccessWay
{
	static int num = 0; //스태틱은 웬만하면 클래스.스택틱변수 이름으로 호출 하는 것이 좋다

	AccessWay()
	{
		incrCnt();
	}

	public void incrCnt()
	{
		num++;
	}
}
