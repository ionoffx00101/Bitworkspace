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
 * use �÷��� �����ӿ�ũ
 * �Է� : (,),[,] ������ �̷���� ���ڿ�
 * (��ȣ�� ���� �¾ƾ��� [(]) �̵��� �ȵ�])
 * ��� : ��ȣ�� ������ ��ü�� ���鼭 ��ȣ�� Ǯ� �� �����
 * 
 * () = 2
 * [] = 3
 * ��ȣ�� ���θ� �� (()) = 2*2 =4
 * ���� ������ ���ϱ� ()[] =5
 * 
 * �Է� : (()[[]])[()]
 * ��� : 28
 * ���� ������ ���÷Ⱦ���Ѵ�...
 */