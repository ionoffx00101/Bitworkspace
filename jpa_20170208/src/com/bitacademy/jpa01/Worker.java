package com.bitacademy.jpa01;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tb_worker")
public class Worker {
	
	@Id
	public Long workerid;
	public String name;
	public Integer age;
	
	// @JoinColumn(name="참고를 하는 테이블의 컬럼명",referencedColumnName="참조를 당하는 테이블의 컬럼명")
	@JoinColumn(name="officenum",referencedColumnName="officenum")
	@OneToOne(cascade=CascadeType.PERSIST) // worker 하나당 office 하나 이기에 one to one 이라고 컴파일러한테 알려주는 것이ㅏㄷ
	public Office office; //officenum 때문이야
	
	public Long getWorkerid() {
		return workerid;
	}
	public void setWorkerid(Long workerid) {
		this.workerid = workerid;
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
	public Office getOffice() {
		return office;
	}
	public void setOffice(Office office) {
		this.office = office;
	}
	
	@Override
	public String toString() {
		return "Worker [workerid=" + workerid + ", name=" + name + ", age=" + age + ", office=" + office + "]";
	}
	
	
}
