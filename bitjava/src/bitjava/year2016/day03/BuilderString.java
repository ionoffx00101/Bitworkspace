package bitjava.year2016.day03;

public class BuilderString
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		StringBuilder strBuf = new StringBuilder();
		strBuf.append(25);
		strBuf.append('Y').append(true);
		System.out.println(strBuf);

		strBuf.insert(2, '_'); // 2ĭ�� _ �о�ֱ�
		strBuf.insert(strBuf.length(), '_'); //length�� buf ũ�⸦ ���Ѵ��� _�� �ְڴٰ� ������ �������� _�� �� 
		System.out.println(strBuf);
	}

}
