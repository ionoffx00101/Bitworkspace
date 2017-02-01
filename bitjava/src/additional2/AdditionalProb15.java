package additional2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdditionalProb15 {

	public static String str1 = "That'sMyStringToCut!";
	public static ArrayList<String> arrStr = new ArrayList<String>();		// str1을 잘라서 담을 컬렉션.
	
	// 주어진 순서대로 컷팅할 때의 비용을 계산하여 리턴하는 메서드.
	public static int calcCost(String strCutPoints) {
		StringTokenizer st = new StringTokenizer(strCutPoints, " ");
		ArrayList<String> arrStrNew = null;
		ArrayList<Integer> arrCost = new ArrayList<Integer>();
		while(st.hasMoreTokens()) {
			arrStrNew = new ArrayList<String>();
					
			String strCutPoint = st.nextToken();
			int numCutPoint = Integer.parseInt(strCutPoint);
			int index=0;
			
			// 한번 컷팅해서 새로운 리스트 객체에 담음.
			boolean bCut = false;
			for(int i=0; i<=arrStr.size()-1; i++) {
				
				if(index == numCutPoint) System.out.println("ERR!"); 
				index+=arrStr.get(i).length();
				if(bCut==false && index > numCutPoint) {
					// CUT this string.
					//System.out.println(arrStr.get(i).substring(0,arrStr.get(i).length()-(index-numCutPoint))); // 잘라낸 왼쪽 문자열
					String str1 = arrStr.get(i).substring(0,arrStr.get(i).length()-(index-numCutPoint)); // str#1  
					//System.out.println(arrStr.get(i).substring( arrStr.get(i).length()-(index-numCutPoint)));	 // 잘라낸 오른쪽 문자열
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
	
	// 모든 경우의 수를 고려하여, 최소값을 구하는 메서드.
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
		
		System.out.println("최소값 : " + costMin);
		
	}
	public static void main(String[] args) {
		
		System.out.print("입력 : ");
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
