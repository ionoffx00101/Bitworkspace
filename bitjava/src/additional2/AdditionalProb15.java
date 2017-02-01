package additional2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdditionalProb15 {

	public static String str1 = "That'sMyStringToCut!";
	public static ArrayList<String> arrStr = new ArrayList<String>();		// str1�� �߶� ���� �÷���.
	
	// �־��� ������� ������ ���� ����� ����Ͽ� �����ϴ� �޼���.
	public static int calcCost(String strCutPoints) {
		StringTokenizer st = new StringTokenizer(strCutPoints, " ");
		ArrayList<String> arrStrNew = null;
		ArrayList<Integer> arrCost = new ArrayList<Integer>();
		while(st.hasMoreTokens()) {
			arrStrNew = new ArrayList<String>();
					
			String strCutPoint = st.nextToken();
			int numCutPoint = Integer.parseInt(strCutPoint);
			int index=0;
			
			// �ѹ� �����ؼ� ���ο� ����Ʈ ��ü�� ����.
			boolean bCut = false;
			for(int i=0; i<=arrStr.size()-1; i++) {
				
				if(index == numCutPoint) System.out.println("ERR!"); 
				index+=arrStr.get(i).length();
				if(bCut==false && index > numCutPoint) {
					// CUT this string.
					//System.out.println(arrStr.get(i).substring(0,arrStr.get(i).length()-(index-numCutPoint))); // �߶� ���� ���ڿ�
					String str1 = arrStr.get(i).substring(0,arrStr.get(i).length()-(index-numCutPoint)); // str#1  
					//System.out.println(arrStr.get(i).substring( arrStr.get(i).length()-(index-numCutPoint)));	 // �߶� ������ ���ڿ�
					String str2 = arrStr.get(i).substring( arrStr.get(i).length()-(index-numCutPoint));  // str#2
					arrStrNew.add(str1);
					arrStrNew.add(str2);
					arrCost.add(arrStr.get(i).length());
					
					bCut = true;
				} else {
					// PASS this string.
					arrStrNew.add(arrStr.get(i));
				}
			}
			arrStr = arrStrNew;
			arrStrNew=null;

			// for(int k=0; k<=arrStr.size()-1; k++) System.out.println(k + " - " + arrStr.get(k));
		
		}
		//System.out.println("--COST--");
		//for(int k=0; k<=arrCost.size()-1; k++) System.out.println(arrCost.get(k));

		int costSum = 0;
		for(int k=0; k<=arrCost.size()-1; k++) costSum += arrCost.get(k);
		
		arrStr.clear();
		arrStr.add(str1);
		
		return costSum;
	}
	
	// ��� ����� ���� ����Ͽ�, �ּҰ��� ���ϴ� �޼���.
	public static void shuffleAndGo(String strCutPoints) {
		StringTokenizer st = new StringTokenizer(strCutPoints, " ");
		ArrayList<String> arrStr = new ArrayList<String>();
		HashSet<String> setStrResult = new HashSet<String>();
		while(st.hasMoreTokens()) {
			arrStr.add(st.nextToken());
		}
		int factorial = 1;
		for(int i=1; i<=arrStr.size(); i++) factorial*=i;

		while(setStrResult.size()!=factorial) {
			ArrayList<String> listOrder = new ArrayList<String>();
			for(int i=1; i<=arrStr.size(); i++) {
				while(listOrder.size()!=i) {
					int randInt = (int)(Math.random()*(arrStr.size())+1); 
					if(!listOrder.contains(arrStr.get(randInt-1))) listOrder.add(arrStr.get(randInt-1));
				}
			}
			String strOrder = "";
		
			for(String e : listOrder) {
				strOrder += e + " ";
			}
			strOrder = strOrder.trim();
			
			setStrResult.add(strOrder);
		}

		int costMin = 99999;   // means the infinite.
		Iterator itr = setStrResult.iterator();
		for(int i=0; i<=setStrResult.size()-1; i++) {
			String strOrder = (String) itr.next();
			int cost = calcCost(strOrder);
			if(cost<costMin) costMin = cost; 
			System.out.println("["+i+"] " + strOrder + " - cost : " + cost);			
		}
		
		System.out.println("�ּҰ� : " + costMin);
		
	}
	public static void main(String[] args) {
		
		System.out.print("�Է� : ");
		Scanner kb = new Scanner(System.in);
		int numSize = kb.nextInt();
		
		String strNumList = "";
		for(int i=1; i<=numSize; i++) {
			int num = kb.nextInt();
			strNumList += num + " ";
		}
		strNumList = strNumList.trim();
		
		arrStr.add(str1);
		shuffleAndGo(strNumList);
		
	}

}
