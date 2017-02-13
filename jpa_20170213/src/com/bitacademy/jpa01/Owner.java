package com.bitacademy.jpa01;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_owner2")
public class Owner {

	@Id // pk인 컬럼이다
	public Long ownernum;
	public String ownername;
	public String address;
	public String phone;
	
	public Long getOwnernum() {
		return ownernum;
	}
	public void setOwnernum(Long ownernum) {
		this.ownernum = ownernum;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getOwnername() {
		return ownername;
	}
	public void setOwnername(String ownername) {
		this.ownername = ownername;
	}
	@Override
	public String toString() {
		return "Owner [ownernum=" + ownernum + ", ownername=" + ownername + ", address=" + address + ", phone=" + phone + "]";
	}
	
	
}
