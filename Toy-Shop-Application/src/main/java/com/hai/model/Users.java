package com.hai.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	public static final String BAN = "ban";
	public static final String ACTIVE = "active";
	public static final String PENDING = "pending";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "User_ID")
	private int id;
	private String passwords;
	private String email;
	private String address;
	private String phone;
	@Column(name = "First_Name")
	private String firstName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "create_Date")
	private Date createDate;
	@Column(name = "Login_Status")
	private String loginStatus;
	private String token;

	//Map to verify Token
	@OneToMany(mappedBy="user")
	private List<VerifyAccountToken> verifyAccountTokens;
	
	// Map to User Role
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<UserRole> roles;

	// Map to Comment
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Review> review;

	// Map to Whishlist
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Wishlist> wishlists;

	// Map to Cart
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private Cart cart;

	// Map to Order
	@OneToMany(mappedBy = "orderUser", cascade = CascadeType.ALL)
	private List<Order> paidUserOrders;
	@OneToMany(mappedBy = "processUser", cascade = CascadeType.ALL)
	private List<Order> processUserOrders;

	// Map to Export
	@OneToMany(mappedBy = "user", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Export> exports = new ArrayList<Export>();

	// Map to Import
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<Import> imports;

	// Getter and setter

	public List<Import> getImports() {
		return imports;
	}

	public void setImports(List<Import> imports) {
		this.imports = imports;
	}

	public List<Export> getExports() {
		return exports;
	}

	public void setExports(List<Export> exports) {
		this.exports = exports;
	}

	public int getId() {
		return id;
	}

	public List<Order> getPaidUserOrders() {
		return paidUserOrders;
	}

	public void setPaidUserOrders(List<Order> paidUserOrders) {
		this.paidUserOrders = paidUserOrders;
	}

	public List<Order> getProcessUserOrders() {
		return processUserOrders;
	}

	public void setProcessUserOrders(List<Order> processUserOrders) {
		this.processUserOrders = processUserOrders;
	}

	public String getPasswords() {
		return passwords;
	}

	public void setPasswords(String passwords) {
		this.passwords = passwords;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public List<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}
	

	public List<VerifyAccountToken> getVerifyAccountTokens() {
		return verifyAccountTokens;
	}

	public void setVerifyAccountTokens(List<VerifyAccountToken> verifyAccountTokens) {
		this.verifyAccountTokens = verifyAccountTokens;
	}


	public enum LoginStatus {
		ACTIVE, PENDING, BAN, CLOSE
	}
	
	


}
