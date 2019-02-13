package com.hai.iservice;

import java.util.List;

import com.hai.command.ReviewCommand;
import com.hai.model.Review;

public interface IReviewService {

	/**
	 * This function is get reviewCommand from user and create review for the product and save to database
	 * @param reviewCommand
	 */
	public Review getReview(ReviewCommand reviewCommand);
	
	
	/**
	 * This function is for getting all review in database 
	 * @return
	 */
	public List<Review> getAllReview();
}
