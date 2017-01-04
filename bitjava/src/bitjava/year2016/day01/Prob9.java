package bitjava.year2016.day01;

import java.text.NumberFormat;

public class Prob9 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int account = 1000;
		int addaccount = account;
		int year = 0;
		while (true) {
			addaccount += addaccount * 0.05;

			if (addaccount / account >= 2) {
				System.out.println(year + "³â °É¸² " + account + "Ã¹µ·  " + addaccount + "ºÒ¾î³­ ³»µ·");
				break;
			}
			year++;
		}
		int money = 1000 * 10000;
		int years = 0;

		for (;;) {
			if (Math.pow(1.05, ++years) > 2)
				break;
		}
		NumberFormat f = NumberFormat.getInstance();
		f.setGroupingUsed(false);
		String val = f.format(money*Math.pow(1.05, ++years));
		System.out.println(val);
	}
}
