package com.bitacademy.good;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_good")
public class Good {

	@Id
	public Long gnum;
	public String name;
	public String detail;
	public Long price;
	public String img;
	
	public Long getGnum() {
		return gnum;
	}
	public void setGnum(Long gnum) {
		this.gnum = gnum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Good [gnum=" + gnum + ", name=" + name + ", detail=" + detail + ", price=" + price + ", img=" + img + "]";
	}
	
	
}
