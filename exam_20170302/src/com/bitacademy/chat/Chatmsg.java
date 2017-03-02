package com.bitacademy.chat;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import org.springframework.data.annotation.CreatedDate;

import com.bitacademy.user.User;
/*tb_chatmsg 테이블과 데이터를 주고 받는 엔티티 클래스

chatnum 컬럼에 chatmsg_seq 시퀀스를 이용해서 데이터가 주가되도록 설정 필요
*/
@SequenceGenerator(name = "chatmsg_seq_gen", sequenceName = "chatmsg_seq", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "TB_CHATMSG")
public class Chatmsg {
	/*
	 chatnum 컬럼에 chatmsg_seq 시퀀스를 이용해서 데이터가 주가되도록 설정 필요
	각 테이블은 id 컬럼을 공유하고 있음 
	PK
	 * */
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatmsg_seq_gen")
	@Id
	private Long chatnum;
	//TB_USER 테이블과 조인되서 user 정보가 저장도 록 설정 필요
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id",referencedColumnName="id")
	private User user;
	private String msg;
	
	@Column(name = "msgdate", updatable = true, nullable = false)
	@CreatedDate
	private java.sql.Date msgdate;
	public Long getChatnum() {
		return chatnum;
	}
	public void setChatnum(Long chatnum) {
		this.chatnum = chatnum;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public java.sql.Date getMsgdate() {
		return msgdate;
	}
	public void setMsgdate(java.sql.Date msgdate) {
		this.msgdate = msgdate;
	}
	@Override
	public String toString() {
		return "Chatmsg [chatnum=" + chatnum + ", user=" + user + ", msg=" + msg + ", msgdate=" + msgdate + "]";
	}
	
}
