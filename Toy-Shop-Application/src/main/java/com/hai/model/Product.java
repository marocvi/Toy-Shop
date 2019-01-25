package com.hai.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "Product")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Product_ID")
	private int id;
	@Column(name = "Product_Name")
	private String name;
	private int stock;
	@Column(columnDefinition = "TEXT")
	private String description;
	private String brand;
	@Column(name = "Profile_Image")
	private String profileImage;
	private long view;
	@Column(name = "Import_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date importDate;
	private int rate;

	@ManyToOne(fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@JoinColumn(name = "Category_ID")
	private Category category;

	// Map to Product_Size
	@OneToMany(mappedBy = "product")
	private List<ProductSize> productSizes;

	// Map to Product_ Image
	@OneToMany(mappedBy = "product")
	private List<ProductImage> productImages;

	// Map to Promotion
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
	private Set<Promotion> promotions;

////	 Map to Special Offer
//	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
//	@OneToOne(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//	private SpecialOffer offer;

	// Map to Supplier
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "Product_Supplier", joinColumns = @JoinColumn(name = "Product_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "Supplier_ID", nullable = false))
	private List<Supplier> suppliers;

	// Map to ProductPrice
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	private Set<ProductPrice> productPrices;

	// Map to wishlist
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Wishlist> wishlists;

	// Map to Cart_Detail
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<CartDetail> cartDetails;

	// map to Order Detail
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();

	// Map to Export Detail
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ExportDetail> exportDetails;

	// Map to Import Detail
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<ImportDetail> importDetails;

	// Map to Review
	@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "product", fetch = FetchType.EAGER)
	private Set<Review> reviews;

	// Getter and setter
	public List<ExportDetail> getExportDetails() {
		return exportDetails;
	}

	public List<ImportDetail> getImportDetails() {
		return importDetails;
	}

	public void setImportDetails(List<ImportDetail> importDetails) {
		this.importDetails = importDetails;
	}

	public void setExportDetails(List<ExportDetail> exportDetails) {
		this.exportDetails = exportDetails;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public List<CartDetail> getCartDetails() {
		return cartDetails;
	}

	public void setCartDetails(List<CartDetail> cartDetails) {
		this.cartDetails = cartDetails;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getView() {
		return view;
	}

	public void setView(long view) {
		this.view = view;
	}

	public Date getImportDate() {
		return importDate;
	}

	public void setImportDate(Date importDate) {
		this.importDate = importDate;
	}

	public Set<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(Set<Promotion> promotions) {
		this.promotions = promotions;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public Set<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Set<Review> reviews) {
		this.reviews = reviews;
	}

	public List<ProductSize> getProductSizes() {
		return productSizes;
	}

	public void setProductSizes(List<ProductSize> productSizes) {
		this.productSizes = productSizes;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public Set<ProductPrice> getProductPrices() {
		return productPrices;
	}

	public void setProductPrices(Set<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
