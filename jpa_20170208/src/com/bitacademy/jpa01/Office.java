package com.bitacademy.jpa01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity // entity랑 연결된 클래스라고 알려줌 
@Table(name="tb_office") // 어떤 테이블과 연결 되었는지 알려줌
public class Office {

	@Id // pk랑 연결된 객체가 어떤 것인지 나와 컴파일러에게 알려줌
	public Long officenum;
	public String officename;
	public String address;
	@Column(name="phone") // 아래 객체랑 연결된 컬럼이름이 다를때 어떤 것인지 나와 컴파일러에게 알려줌
	public String officephone;
	
	public Long getOfficenum() {
		return officenum;
	}
	public void setOfficenum(Long officenum) {
		this.officenum = officenum;
	}
	public String getOfficename() {
		return officename;
	}
	public void setOfficename(String officename) {
		this.officename = officename;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOfficephone() {
		return officephone;
	}
	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}
	@Override
	public String toString() {
		return "Office [officenum=" + officenum + ", officename=" + officename + ", address=" + address + ", officephone=" + officephone + "]";
	}

}
