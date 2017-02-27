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

import org.hibernate.annotations.CreationTimestamp;

import com.bitacademy.user.User;

@SequenceGenerator(name = "chatmsg_seq_gen",sequenceName = "chatmsg_seq", initialValue = 1, allocationSize = 1)
@Entity
@Table(name = "tb_chatmsg")
public class Chatmsg
{
	@Id // 시퀀스 연결해야한다 아 귀찮다 해야한다
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chatmsg_seq_gen")
	private Long chatnum;
	@OneToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="id",referencedColumnName="id")//(name="내 컬럼명",referencedColumnName="재 컬럼명")
	private User user;
	private String msg;
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "msgdate")
	private java.sql.Date msgdate;// 날짜설정해야하네 ^

	public Chatmsg()
	{
		super();
	}

	public Long getChatnum()
	{
		return chatnum;
	}
	public void setChatnum(Long chatnum)
	{
		this.chatnum = chatnum;
	}
	public User getUser()
	{
		return user;
	}
	public void setUser(User user)
	{
		this.user = user;
	}
	public String getMsg()
	{
		return msg;
	}
	public void setMsg(String msg)
	{
		this.msg = msg;
	}
	public java.sql.Date getMsgdate()
	{
		return msgdate;
	}
	public void setMsgdate(java.sql.Date msgdate)
	{
		this.msgdate = msgdate;
	}

	@Override
	public String toString()
	{
		return "Chatmsg [chatnum=" + chatnum + ", user=" + user + ", msg=" + msg + ", msgdate=" + msgdate + "]";
	}
}
