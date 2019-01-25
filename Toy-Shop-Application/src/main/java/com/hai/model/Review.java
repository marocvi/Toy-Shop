package com.hai.model;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Review")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Review_ID")
	private int id;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Created_Date")
	private Date createDate;
	private String image;
	private byte rate;
	@Column(name="User_Name")
	private String userName;

	// Create foreign key
	@ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.LAZY)
	@JoinColumn(name = "User_ID", nullable = false)
	private Users user;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name ="Product_ID",nullable= false)
	private Product product;
	
	
	
	
	
	//Getter and setter
	public int getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getRate() {
		return rate;
	}

	public void setRate(byte rate) {
		this.rate = rate;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	private int likes;

}
