package com.bitacademy.good;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@SequenceGenerator(name = "good_seq20170220_gen",sequenceName = "good_seq20170220", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "TB_GOOD20170220")
public class Good
{

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "good_seq20170220_gen")
	@Id
	private Long gnum;
	private String name;
	private Long price;
	@Transient
	private Long qty;
	private String detail;
	private String img;

	// JPA를 위한 매개변수 없는 생성자
	public Good()
	{
		super();
	}

	public Good(Long gnum, String name, Long price, Long qty, String detail, String img)
	{
		super();
		this.gnum = gnum;
		this.name = name;
		this.price = price;
		this.qty = qty;
		this.detail = detail;
		this.img = img;
	}

	// alt+shift+s > generate
	// hash and equal
	// 검색을 원하는 속성 클릭.. 알아서 만들어줌
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((gnum == null) ? 0 : gnum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Good other = (Good) obj;
		if (gnum == null)
		{
			if (other.gnum != null)
				return false;
		}
		else if (!gnum.equals(other.gnum))
			return false;
		return true;
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
