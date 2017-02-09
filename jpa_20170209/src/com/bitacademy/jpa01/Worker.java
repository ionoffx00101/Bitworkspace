package com.bitacademy.jpa01;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "tb_worker")
public class Worker {

	@Id
	public Long workerid;
	public String name;
	public Integer age;

	// Contact에서 다중 조인하기 이거 말 되나? 다중조인? 
	@OneToMany(mappedBy="worker", cascade=CascadeType.PERSIST)
	public List<Contact> contacts;

	public List<Contact> getContacts() {
		return contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public boolean addContact(Contact contact) {
		// 오 이것은 많은 줄의 contact를 가져와서 리스트에 넣어주는 메소드이다..ㅇ
		// 조회한 변수가 매개변수로 온다
		if (contact == null) {
			// 값이 없을때는 초기화 시킨다
			contacts = new ArrayList<Contact>();
		}
		contacts.add(contact);
		return true;
	}

	// @JoinColumn(name="참고를 하는 테이블의 컬럼명",referencedColumnName="참조를 당하는 테이블의 컬럼명")
	@JoinColumn(name = "officenum", referencedColumnName = "officenum")
	@OneToOne(cascade = CascadeType.PERSIST)
	// worker 하나당 office 하나 이기에 one to one 이라고 컴파일러한테 알려주는 것이ㅏㄷ
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
		return "Worker [workerid=" + workerid + ", name=" + name + ", age=" + age + ", contacts=" + contacts + ", office=" + office + "]";
	}

	

}
