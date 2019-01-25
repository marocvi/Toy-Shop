package com.hai.tag;

import java.util.HashSet;
import java.util.Set;

import com.hai.model.Review;

public class ReviewTag {

	//Get average review rate from list of review
	public static int getReviewRate(Set<Review> reviews) {
		if(reviews.size()==0) return 0;
		double avgRate = 0.0;
		for (Review review : reviews) {
			avgRate+=review.getRate();
		}
		avgRate = avgRate/reviews.size();
		if(avgRate>=1 && avgRate <1.5) return 1;
		else if(avgRate<2.5) return 2;
		else if(avgRate<3.5) return 3;
		else if(avgRate<4.5) return 4;
		else return 5;
	}
	
	//Test 
	public static void main(String[] args) {
		Set<Review> reviews  = new HashSet<>();
		Review review1= new Review();
		review1.setRate((byte) 1);
		Review review2= new Review();
		review2.setRate((byte) 1);
		Review review3= new Review();
		review3.setRate((byte) 1);
		reviews.add(review1);
		reviews.add(review2);
		reviews.add(review3);
		System.out.println(getReviewRate(reviews));
		
		
	}
}
