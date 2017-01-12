package bitjava.day01_11;

import java.util.Stack;

public class Prob1
{
	public static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args)
	{

	}

	public static void showStack()
	{

	}

	public static void calcClosing(int thisChar)
	{

	}

	public static void plusNum()
	{

	}

}
/*
 * use 컬렉션 프레임워크
 * 입력 : (,),[,] 만으로 이루어진 문자열
 * (괄호의 쌍이 맞아야함 [(]) 이딴거 안됨])
 * 출력 : 괄호를 값으로 대체해 가면서 괄호를 풀어낸 후 결과값
 * 
 * () = 2
 * [] = 3
 * 괄호를 감싸면 곱 (()) = 2*2 =4
 * 옆에 붙으면 더하기 ()[] =5
 * 
 * 입력 : (()[[]])[()]
 * 출력 : 28
 * 스택 구조를 떠올렸어야한다...
 */