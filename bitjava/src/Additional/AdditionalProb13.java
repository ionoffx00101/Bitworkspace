package Additional;
import java.util.Stack;
import java.util.StringTokenizer;

// 2017-01-20(FRI)~23(MON)
// 중위표기법 입력 -> 후위표기법 변환 출력 -> 계산결과 출력
public class AdditionalProb13 {
	public static Stack<Character> stackOperator = new Stack<Character>();
	public static boolean isNumber(char ch) {
		if(ch>='0' && ch<='9') return true;
		else return false;
	}
	public static String infixToPostfix(String str) {
		String strOutput = "";
		
		for(int i=0; i<=str.length()-1; i++) {
			char ch = str.charAt(i);
			if(isNumber(ch)) {
				int num = ch - '0';
				if(i+1<=str.length()-1 && isNumber(str.charAt(i+1))) {
					num = num*10 + (str.charAt(++i)-'0');
				}
				strOutput += num + " ";
				continue;
			}
			else {
				if(ch=='+' || ch=='-') {
					if(!stackOperator.isEmpty())
						while(stackOperator.peek()=='*' || stackOperator.peek()=='/') {
							strOutput += stackOperator.pop() + " ";
						}
					if(!stackOperator.isEmpty())
						if(stackOperator.peek()=='+' || stackOperator.peek()=='-')
							strOutput += stackOperator.pop() + " ";
					stackOperator.push(ch);
				}
				else if(ch=='*' || ch=='/') {
					if(!stackOperator.isEmpty())
						if(stackOperator.peek()=='*' || stackOperator.peek()=='/')
							strOutput += stackOperator.pop() + " ";
					stackOperator.push(ch);
				}
				else if(ch=='(') {
					stackOperator.push(ch);
				}
				else if(ch==')') {
					if(!stackOperator.isEmpty())
						while(stackOperator.peek()!='(') {
							char chOperator = stackOperator.pop();
							strOutput += chOperator + " ";
						}
					stackOperator.pop();	// pop the '('
				}
			}
		}
		while(!stackOperator.isEmpty()) {
			strOutput += stackOperator.pop() + " ";
		}
		return strOutput;
	}
	public static double calcPostfix(String str) {
		return 0.0;
	}
	public static void main(String[] args) {
		String strInput = "(2*(3+6/2)+2)-4/3";
		String strInput2 = "3-35/(5/2)+2*28*(3/2+1-3)";
		String strInput3 = "2+3*2-3+40/10";
		String strInput4 = "40+20*4+4+4+2*(0+3*(10-2*10))";
		
		System.out.println(infixToPostfix(strInput) + "(=" + calcPostfix(infixToPostfix(strInput)) + ")");
		System.out.println(infixToPostfix(strInput2) + "(=" + calcPostfix(infixToPostfix(strInput2)) + ")");
		System.out.println(infixToPostfix(strInput3) + "(=" + calcPostfix(infixToPostfix(strInput3)) + ")");
		System.out.println(infixToPostfix(strInput4) + "(=" + calcPostfix(infixToPostfix(strInput4)) + ")");
		
		
		// 2 3 6 2 / + * 2 + 4 3 / - (=12.67....)
		// 3 35 5 2 / / - 2 28 * 3 2 / 1 + 3 - * +
		// 2 3 2 * + 3 - 40 10 / + 
		// 40 20 4 * + 4 + 4 + 2 0 3 10 2 10 * - * + * +
		 
		
		 
	}

}
