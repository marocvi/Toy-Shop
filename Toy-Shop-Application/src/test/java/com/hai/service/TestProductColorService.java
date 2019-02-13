package com.hai.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.RootConfig;
import com.hai.config.SpringWebContextConfig;
import com.hai.iservice.IProductColorService;
import com.hai.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class,RootConfig.class})
@WebAppConfiguration
public class TestProductColorService {

	@Autowired
	IProductColorService productColorService;
	
	@Test
	public void testGetColorByProduct() {
		Product product = new Product();
		product.setId(1);
		assertEquals(3, productColorService.findColorsByProduct(product).size());
		
	}
	
}
