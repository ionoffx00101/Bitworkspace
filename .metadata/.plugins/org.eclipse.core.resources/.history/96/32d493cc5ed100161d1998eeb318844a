package bitjava.day05;

public class HASAInheritance
{

	public static void main(String[] args)
	{
		Police p = new Police(5, 2);
		p.shoot();
		p.putHandcuff();
	}

}

class Gun
{
	int bullet;

	public Gun(int bnum)
	{
		bullet = bnum;

	}

	public void shoot()
	{
		System.out.println("ÅÁ");
		bullet -= 1;
	}
}

class Police extends Gun
{
	int handcuffs;

	public Police(int bnum, int bcuffs)
	{
		super(bnum);
		handcuffs = bcuffs;

	}

	public void putHandcuff()
	{
		System.out.println("Ã¶ÄÈÃ¶ÄÈ");
		bullet--;
	}
}