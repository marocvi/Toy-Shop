package com.hai.idao;

import java.util.List;

import com.hai.model.Review;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IReviewDAO {
	
	public boolean createReview(Review review);
	public Review readReview(int reviewID);
	public boolean updateReview(Review review);
	public boolean deleteReview(int reviewID);
	public List<Review> readAllReviews();
	public List<Review> readReviewByProperty(String name, Object value);
	
}
