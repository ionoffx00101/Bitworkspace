package jpa_20170207;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_MEMBER") //조회할 테이블은 어디냐
public class Member {
	
	@Id // 프라이머리키는 뭐냐 
	public Long num;   // 근데 왜 Long을 쓸까
	public String name;
	public Integer age; // 근데 왜 Integer를 쓸까
	
	public Long getNum() {
		return num;
	}
	public void setNum(Long num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Member [num=" + num + ", name=" + name + ", age=" + age + "]";
	}

}
