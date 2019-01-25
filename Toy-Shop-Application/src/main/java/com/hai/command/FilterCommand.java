package com.hai.command;

import java.util.Arrays;
import java.util.Date;

import com.hai.model.Product;
import com.hai.model.Promotion;
import com.hai.model.Review;
import com.hai.service.ProductPriceServiceImpl;

public class FilterCommand {

	private long minPrice;
	private long maxPrice = 1000;
	private String[] category;
	private int[] promotion;
	private int[] review;

	public long getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(long minPrice) {
		this.minPrice = minPrice;
	}

	public long getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(long maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public int[] getPromotion() {
		return promotion;
	}

	public void setPromotion(int[] promotion) {
		this.promotion = promotion;
	}

	public int[] getReview() {
		return review;
	}

	public void setReview(int[] review) {
		this.review = review;
	}

	@Override
	public String toString() {
		return "FilterCommand [minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", category="
				+ Arrays.toString(category) + ", discount=" + Arrays.toString(promotion) + ", rate="
				+ Arrays.toString(review) + "]";
	}

	// Check if filter is valid or invalid
	public boolean isEmpty() {
		if (category == null || promotion == null || review == null)
			return true;
		if (category.length == 0 && promotion.length == 0 && review.length == 0&&maxPrice==minPrice)
			return true;
		return false;
	}
	
	
	public boolean applyPriceCondition(Product product) {
		//Check price valid in range of min price and max price
		if (minPrice < ProductPriceServiceImpl.getCurrentPrice(product.getProductPrices())
				&& maxPrice > ProductPriceServiceImpl.getCurrentPrice(product.getProductPrices()))
			return true;
		return false;
	}
	public boolean applyCategoryCondition(Product product) {
		//Check if category of product within filter category
		for(int i=0;i<category.length;i++) {
			if(product.getCategory().getName().equals(category[i]))
				return true;
		}
		return false;
	}
	
	public boolean applyPromotionCondition(Product product) {
		//Get current promotion from product wich is valid within date
		Date today = new Date();
		Promotion promotion = null;
		for(Promotion tempPromotion: product.getPromotions()) {
			if(tempPromotion.getCreateDate().before(today)&&tempPromotion.getEndDate().after(today)) {
				promotion = tempPromotion;
				break;
			}
		}
		//If there is no promotion valid
		if(promotion==null) {
			return false;
		}
		else {
			
			for(int i=0;i<this.promotion.length;i++) {
				//If there is a promotion  which has rate fit to promotion rate codintion then return true else return false;
				if(promotion.getRate()>=this.promotion[i]&&promotion.getRate()<=this.promotion[i]+10) return true;
			}
			return false;
		}
		
	}
	public boolean applyReviewCondition(Product product) {
		//Check if there is review for this product
		if(product.getReviews().size()==0) return false;
		int reviewRate=0;
		//Get total mark of review Rate
		for(Review review: product.getReviews()) {
			reviewRate+=review.getRate();
		}
		//Get average mark of review Rate
		reviewRate /=product.getReviews().size();
		for(int i=0;i<review.length;i++) {
			if(review[i]-0.5<reviewRate&&review[i]+0.5>reviewRate) return true;
		}
		return false;
	}

}


