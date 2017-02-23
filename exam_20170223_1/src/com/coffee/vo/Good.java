package com.coffee.vo;

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
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "good_seq20170220_gen")
	private Long gnum;
	private String name;
	private Long price;
	@Transient
	private Long qty;
	private String detail;
	private String img;
	
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
		return "Good [gnum=" + gnum + ", name=" + name + ", price=" + price + ", qty=" + qty + ", detail=" + detail + ", img=" + img + "]";
	}
}
