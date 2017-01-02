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
	static int num = 0; //����ƽ�� �����ϸ� Ŭ����.����ƽ���� �̸����� ȣ�� �ϴ� ���� ����

	AccessWay()
	{
		incrCnt();
	}

	public void incrCnt()
	{
		num++;
	}
}
