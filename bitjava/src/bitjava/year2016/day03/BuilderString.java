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

		strBuf.insert(2, '_'); // 2칸에 _ 밀어넣기
		strBuf.insert(strBuf.length(), '_'); //length로 buf 크기를 구한다음 _를 넣겠다고 했으니 마지막에 _가 들어감 
		System.out.println(strBuf);
	}

}
