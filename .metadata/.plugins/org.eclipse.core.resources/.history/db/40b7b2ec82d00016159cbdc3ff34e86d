package bitjava.day2;

class FruitSeller {
	private int numOfApple;  //private 추가시킴 정보은닉관련 학습
	private int myMoney;  //private 추가시킴 정보은닉관련 학습
	private final int APPLE_PRICE;  //private 추가시킴 정보은닉관련 학습

	public FruitSeller(int money, int appleNum, int price) {
		numOfApple = appleNum;
		myMoney = money;
		APPLE_PRICE = price;
	}

	public int saleApple(int money) {
		int num = money / APPLE_PRICE;
		numOfApple -= num;
		myMoney += money;
		return num;
	}

	public void showSalesResult() {
		System.out.println("남는사과" + numOfApple);
		System.out.println("판매수익" + myMoney);
	}
}

class FruitBuyer {
	private int mymoney;   //private 추가시킴 정보은닉관련 학습
	private int numOfApple;   //private 추가시킴 정보은닉관련 학습

	public FruitBuyer(int money) {
		mymoney = money;
		numOfApple = 0;
	}

	public void buyApple(FruitSeller seller, int money) {
		numOfApple += seller.saleApple(money);
		mymoney -= money;

	}

	public void showBuyResult() {
		System.out.println("현재잔액" + mymoney);
		System.out.println("사과 개수" + numOfApple);
	}
}

public class FruitSales {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//객체를 생성
		FruitSeller fs1 = new FruitSeller(5000, 6, 500);
		FruitSeller fs2 = new FruitSeller(6000, 15, 200);
		FruitBuyer fb = new FruitBuyer(10000);

		//거래
		fb.buyApple(fs1, 4500);
		fb.buyApple(fs2, 5000);

		//영수증 출력
		fs1.showSalesResult();
		fs2.showSalesResult();
		fb.showBuyResult();
	}

}
