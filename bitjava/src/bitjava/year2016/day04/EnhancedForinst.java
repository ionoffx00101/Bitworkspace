package bitjava.year2016.day04;
class Number
{	private int num;
	public Number(int num)
	{		this.num = num;}
	public int getNum()
	{		return num;}
	public void addNum(int add)
	{		num += add;}
}
public class EnhancedForinst
{

	public static void main(String[] args)
	{
		Number[] arr=new Number[] {
				new Number(2),
				new Number(4),
				new Number(8)
		};
		
		for(Number e:arr){
			e.addNum(1); //�ϳ��� �ݺ��Ǹ鼭 arr�� +1�� ������ ���� Ŭ���������аͿ� ���� �����°�
		}
		
		for(Number e:arr){
			System.out.print(e.getNum()+"	");
			
		}
		
		System.out.println();
		
		for(Number e:arr){
			e= new Number(5); //e�� ���� �Ŀ� e�� 5�� ���� ��ü�� ���� 
			e.addNum(2);
			System.out.print(e.getNum()+"	");
		}
		
		System.out.println();
		
		for(Number e:arr){
			System.out.print(e.getNum()+"	");
		}
	}

}

