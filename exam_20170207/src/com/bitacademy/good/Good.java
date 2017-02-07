package com.bitacademy.good;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@SequenceGenerator(name = "GOOD_SEQ_GEN", sequenceName = "GOOD_SEQ", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "TB_GOOD")
public class Good {
	
	// gnum은 시퀀스가 관리함, 그 시퀀스는 GOOD_SEQ_GEN이라고 이름지어준 설정을 따름
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GOOD_SEQ_GEN")
	@Id  // gnum이 pk라고 인식하라고 추가하긴 했는데 시퀀스 설정 위에해야하는지 밑에해야하는지 모르겠다
	public Long gnum;//물건번호
	public String name;//물건이름
	public String detail;//물건 설명
	public long price;//물건 단가
	public String img;//물건 이미지 파일의 이름

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

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
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