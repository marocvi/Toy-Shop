package com.hai.model;

import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "Cart")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
@Cacheable
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Cart_ID")
	private int id  ;
	@Column(name = "Money_Total")
	private double moneyTotal;
	

	
	//Map to  user
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "User_ID", unique = true)
	private Users user;
	
	//Map to Cart_Detail
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	private List<CartDetail > cartDetails ;


	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getMoneyTotal() {
		return moneyTotal;
	}

	public void setMoneyTotal(double moneyTotal) {
		this.moneyTotal = moneyTotal;
	}


	
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}




	
}
