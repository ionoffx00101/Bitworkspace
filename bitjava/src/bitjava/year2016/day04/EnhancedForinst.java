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
			e.addNum(1); //하나씩 반복되면서 arr에 +1을 시켜줌 위에 클래스만들어둔것에 들어갔다 나오는것
		}
		
		for(Number e:arr){
			System.out.print(e.getNum()+"	");
			
		}
		
		System.out.println();
		
		for(Number e:arr){
			e= new Number(5); //e가 들어온 후에 e가 5가 들은 객체로 변함 
			e.addNum(2);
			System.out.print(e.getNum()+"	");
		}
		
		System.out.println();
		
		for(Number e:arr){
			System.out.print(e.getNum()+"	");
		}
	}

}

