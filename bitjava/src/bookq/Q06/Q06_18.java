package bookq.Q06;

public class Q06_18
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}
class MemberCall{
	static int iv=10; //int iv=10;
	static int cv=20;
	
	int iv2=cv;
	static int cv2=iv;
	
	static void staticMethod1(){
		System.out.println(cv);
		System.out.println(iv);
	}
	static void instanceMethod1(){ //void instanceMethod1(){
		System.out.println(cv);
		System.out.println(iv);
	}
	static void staticMethod2(){
		staticMethod1();
		instanceMethod1();
	}
	void instanceMethod2(){
		staticMethod1();
		instanceMethod1();
	}
	
}
