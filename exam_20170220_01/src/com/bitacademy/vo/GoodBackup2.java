package com.bitacademy.vo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TB_GOOD20170220")
public class GoodBackup2
{
	@Id
	private Long gnum;
	private String name;
	private Long price;
	@Transient
	private Long qty;
	private String detail;
	private String img;

	// JPA를 위한 매개변수 없는 생성자
	public GoodBackup2()
	{
		super();
	}

	public GoodBackup2(Long gnum, String name, Long price, Long qty, String detail, String img)
	{
		super();
		this.gnum = gnum;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.detail = detail;
		this.img = img;
	}

	// equals() 재정의
	// 에러 안나면 재정의 잘 된 것이다.
	// 원래 equals() 가 하는 일은 객체 주소가 같으면 true를 리턴하는 일
	// gnum이 같으면 true를 리턴하게 재정의
	@Override
	public boolean equals(Object other)
	{
		// 내 굿과 other로 들어온 굿의 객체 주소값이 같을 때
		if (this == other)
		{
			return true;
		}

		// gnum이 null일때
		if (gnum == null)
		{
			return false;
		}

		// ? other의 객체형이 Good이 아니다?
		if (!(other instanceof GoodBackup2))
		{
			return false;
		}

		// 내 gnum과 other의 gnum이 같다
		if (this.getGnum().equals(((GoodBackup2) other).getGnum()))
		{
			return true;
		}

		// 어디에서도 걸리지 않았으니 false을 리턴해준다.
		return false;
	}

	// hashCode() 재정의
	// 원래는 정수값이 같으면 같은 hashCode() 리턴
	// 31+(gnum.hashcode()) 리턴
	@Override // 내가 재정의를 잘했나 궁금할때는 override를 붙여보면 안다 ㅎㅎ
	public int hashCode()
	{
		int code = 0;
		if (gnum != null)
		{
			code = gnum.hashCode();
		}
		int prime = 31;
		int result = prime + code;

		return result;
	}

	public Long getGnum()
	{
		return gnum;
	}
	public void setGnum(Long gnum)
	{
		this.gnum = gnum;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public Long getPrice()
	{
		return price;
	}
	public void setPrice(Long price)
	{
		this.price = price;
	}
	public Long getQty()
	{
		return qty;
	}
	public void setQty(Long qty)
	{
		this.qty = qty;
	}
	public String getDetail()
	{
		return detail;
	}
	public void setDetail(String detail)
	{
		this.detail = detail;
	}
	public String getImg()
	{
		return img;
	}
	public void setImg(String img)
	{
		this.img = img;
	}

	@Override
	public String toString()
	{
		return "Cart [gnum=" + gnum + ", name=" + name + ", price=" + price + ", qty=" + qty + ", detail=" + detail + ", img=" + img + "]";
	}
}
