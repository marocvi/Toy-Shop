package com.hai.model;

import java.util.Date;

import javax.persistence.Cacheable;
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
@Table(name="Promotion")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Promotion {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Promotion_ID")
	private int id;
	private int rate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="Create_Date")
	private Date createDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="End_Date")
	private Date endDate;
	
	
	//Map to Product
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Product_ID")
	private Product product;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}


	public Date getCreateDate() {
		return createDate;
	}


	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
