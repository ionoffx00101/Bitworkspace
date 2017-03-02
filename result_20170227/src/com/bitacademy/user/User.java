package com.bitacademy.user;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

//TB_USER 테이블과 데이터를 주고 받는 엔티티 클래스 
@Entity
@Table(name = "TB_USER")
public class User {
	@Id
	private String id;
	private String name;
	private String nickname;
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", nickname=" + nickname + ", pw=" + pw + "]";
	}
	
	
}
