package com.hai.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.command.ReviewCommand;
import com.hai.idao.IReviewDAO;
import com.hai.iservice.IReviewService;
import com.hai.iservice.IUserService;
import com.hai.model.Review;

@Service
public class ReviewServiceImpl implements IReviewService {

	@Autowired
	private IReviewDAO reviewDAO;
	@Autowired
	private IUserService userService;
	
		
	
	@Override
	public Review getReview(ReviewCommand reviewCommand) {
		//Get review
		Review review = new Review();
		review.setEmail(reviewCommand.getEmail());
		review.setFirstName(reviewCommand.getFirstName());
		review.setLastName(reviewCommand.getLastName());
		review.setContent(reviewCommand.getContent());
		review.setProduct(reviewCommand.getProduct());
		review.setCreateDate(new Date());
		review.setReviewRate(reviewCommand.getReviewRate());
		review.setUser(userService.getUserByEmail(reviewCommand.getEmail()));
		return review;
		
		
	}


	@Override
	public List<Review> getAllReview() {
		
		return reviewDAO.readAllReviews();
	}

}
