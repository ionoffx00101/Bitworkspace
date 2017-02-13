package com.bitacademy.buy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.bitacademy.customer.Customer;
import com.bitacademy.good.Good;

@Entity
@Table(name="tb_buy")
public class Buy {

	@Id
	public Long bnum;
	public Long bgnum;
	public Long qty;
	public java.sql.Date bdate;
	
	// 구매한 고객 이름
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id",referencedColumnName="id")
	/*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")*/
	public Customer customer;
	
	// 구매한 물건 번호
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="gnum",referencedColumnName="gnum")
	public Good good;
	
	public Long getBnum() {
		return bnum;
	}
	public void setBnum(Long bnum) {
		this.bnum = bnum;
	}
	public Long getBgnum() {
		return bgnum;
	}
	public void setBgnum(Long bgnum) {
		this.bgnum = bgnum;
	}
	public Long getQty() {
		return qty;
	}
	public void setQty(Long qty) {
		this.qty = qty;
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public java.sql.Date getBdate() {
		return bdate;
	}
	public void setBdate(java.sql.Date bdate) {
		this.bdate = bdate;
	}
	@Override
	public String toString() {
		return "Buy [bnum=" + bnum + ", bgnum=" + bgnum + ", qty=" + qty + ", bdate=" + bdate + ", customer=" + customer + ", good=" + good + "]";
	}
	
	
	
}
