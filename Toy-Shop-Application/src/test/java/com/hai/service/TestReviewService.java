package com.hai.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.command.ReviewCommand;
import com.hai.config.RootConfig;
import com.hai.config.SpringWebContextConfig;
import com.hai.iservice.IProductService;
import com.hai.iservice.IReviewService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {RootConfig.class,SpringWebContextConfig.class})
@WebAppConfiguration
public class TestReviewService {

	@Autowired
	IReviewService reviewService;
	
	
	@Autowired
	IProductService productService;
	
	
	@Test
	public void testSaveReview() {
		
		ReviewCommand reviewCommand = new ReviewCommand();
		reviewCommand.setEmail("goitenem@gmail.com");
		reviewCommand.setContent("hahaha");
		reviewCommand.setFirstName("hai");
		reviewCommand.setLastName("What's up");
		reviewCommand.setReviewRate((byte)4);
		reviewCommand.setProduct(productService.getPrductById(1));
		int totalReview = reviewService.getAllReview().size();
		reviewService.getReview(reviewCommand);
		assertEquals(totalReview+1,reviewService.getAllReview().size());
		
		
		
	}
	
}
