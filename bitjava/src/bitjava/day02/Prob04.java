package bitjava.day02;

public class Prob04
{

	public static void main(String[] args)
	{
		int x=7;
		Primenumber prime = new Primenumber(x);

	}

}
class Primenumber{
	public Primenumber(int a){
		System.out.println("가동");
		//소수 구하는 식
		//구한 소수중에 a랑 맞는게 있는지
		//있으면 true
		//없으면 소수 다쓰기
		int count =0;
		for (int i = 1; i < a; i++)
		{System.out.println("가동2"+count);
			if(a%i==0){
				
			}else{
				count++;
			}
			
		}
		if(count>2){
			System.out.println("소수");
		}
		
		
		System.out.println("끝");
	
		
	}
}