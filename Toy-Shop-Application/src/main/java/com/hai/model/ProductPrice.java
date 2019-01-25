package com.hai.model;


import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="Product_Price")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class ProductPrice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Product_Price")
	private int id;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="Product_ID",nullable=false)
	private Product product;
	@Column(name = "Unit_Price")
	private Double unitPrice;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Start_Date",length=20)
	private Date startDate;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "End_Date",length=20)
	private Date endDate;

	//Getter and setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

}
