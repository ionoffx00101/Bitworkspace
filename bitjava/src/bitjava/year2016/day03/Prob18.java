package bitjava.year2016.day03;

public class Prob18
{
	//- ���ִ� �ǵ� substring ����ϴ� ����̶� StringBuilder Ŭ���� �̿��ϴ� ���
	public static void main(String[] args)
	{
		String str = "990102-1012345";
		StringBuilder sb = new StringBuilder(str);
		//str=str.replaceAll(str.substring(str.indexOf("-")), "");

		System.out.println(str.replaceAll("-", ""));
		// substring ����ϴ� ���
		System.out.println(str.substring(0, 6) + str.substring(7));
		
		System.out.println(str.substring(0,str.indexOf("-"))+str.substring(7));

		//StringBuilder Ŭ���� �̿��ϴ� ���
		//sb.append(sb.replace(start, end, "-"));
		//sb.append(sb.toString().replaceAll("-", ""));
		//sb.deleteCharAt(sb.toString().indexOf("-"));
		sb.deleteCharAt(sb.indexOf("-"));
		//System.out.println(str);
		System.out.println(sb);
	}

}