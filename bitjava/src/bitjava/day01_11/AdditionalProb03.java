package bitjava.day01_11;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class AdditionalProb03 {
	public static Stack<Integer> stack = new Stack<Integer>();
	
	public static void showStack() {
		System.out.print("[Stack] ");
		Iterator itr = stack.iterator();
		while(itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}
	public static void calcClosing(int thisChar) {
		if(stack.peek()!=-10 && stack.peek()!=-1) {		// (숫자) 또는 [숫자]인 경우.
			int num = stack.pop();		// pop number
			if(stack.peek() == -1) {
				stack.pop();			// pop '('
				num = 2 * num;
				stack.add(num);
			} else if(stack.peek() == -10) {
				stack.pop();			// pop '['
				num = 3 * num;
				stack.add(num);
			}
		}
		else if(stack.peek()==-1) {		// () 인 경우
			stack.pop();
			if(thisChar == -1) stack.add(2);
			else if(thisChar == -10) stack.add(3);
		}
		else if(stack.peek()==-10) {	// [] 인 경우
			stack.pop();
			if(thisChar == -1) stack.add(2);
			else if(thisChar == -10) stack.add(3);
		}
		plusNum();
	}
	public static void plusNum() {
		if(stack.isEmpty()) return;
		int num1=-999, num2=-999;		// -999 is default value.
		if(!stack.isEmpty() && stack.peek()>=0) {
			num1 = stack.pop();
			if(!stack.isEmpty() && stack.peek()>=0) {
				num2 = stack.pop();
			} else {
				stack.add(num1);
			}
		}
		if(num1>=0 && num2>=0) stack.add(num1+num2);	// 즉, 스택에 맨위=숫자, 그바로밑=숫자 였던 경우.
	}
	public static void main(String[] args) {
		
		//String strInput = "(()[[]])[()]";
		String strInput;
		Scanner kb = new Scanner(System.in);
		System.out.print("(, ), [, ] 만으로 입력하세요 : ");
		strInput = kb.nextLine();
		
		int result=0;
		for(int i=0; i<strInput.length(); i++) {
			
			char chNow = strInput.charAt(i);
			
			if(chNow == '(') { 
				stack.add(-1);
				continue;
			}
			if(chNow == '[') { 
				stack.add(-10);
				continue;
			}
			if(chNow == ']') { 
				calcClosing(-10);
				continue;
			}
			if(chNow == ')') { 
				calcClosing(-1);
				continue;
			}
		}

//		showStack();
		
		System.out.println("결과 : " + stack.pop());
	}

}
