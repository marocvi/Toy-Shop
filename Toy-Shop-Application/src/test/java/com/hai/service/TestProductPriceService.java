package com.hai.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.iservice.IProductPriceService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SpringWebContextConfig.class)
@WebAppConfiguration
public class TestProductPriceService {
	
	@Autowired
	IProductPriceService productPriceService;
	

	@Test
	public void testGetCurrentPrice() {
		
		assertEquals(45, productPriceService.getCurrentPrice(1),0);
		
		
	};
	
	
}
