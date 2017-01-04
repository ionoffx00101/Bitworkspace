package bitjava.day01_04;

public class GenericBaseFruitBox
{

	public static void main(String[] args)
	{
		FruitBox<Orange> box1 = new FruitBox<Orange>();
		box1.store(new Orange(10));
		Orange org = box1.pullOut();
		org.showSugarContent();

		FruitBox<Apple> box2 = new FruitBox<Apple>();
		box2.store(new Apple(10));
		Apple app = box2.pullOut();
		app.showAppleWeight();
	}

}

class Orange
{
	int sugarContent;

	public Orange(int sugar)
	{
		sugarContent = sugar;
	}

	public void showSugarContent()
	{
		System.out.println("당도" + sugarContent);
	}
}

class Apple
{
	int weight;

	public Apple(int weight)
	{
		this.weight = weight;
	}

	public void showAppleWeight()
	{
		System.out.println("무게" + weight);
	}
}

class FruitBox<T>
{
	T item;

	public void store(T item)
	{
		this.item = item;
	}

	public T pullOut()
	{
		return item;
	}
}