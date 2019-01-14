package com.hai.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Verify_Account_Token")
public class VerifyAccountToken {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Token_ID")
	private int id;
	private String token;
	@Column(name="Create_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	@Column(name="End_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date endDate;
	
	
	//Mapping
	@ManyToOne
	@JoinColumn(name="User_ID",nullable=false)
	private Users user;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
}
