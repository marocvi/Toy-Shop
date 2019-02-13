package com.hai.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.idao.IProductDAO;
import com.hai.iservice.IProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestProductSevice {
	@Autowired
	IProductService productService;
	
	@Autowired
	IProductDAO productDAO;
	
	
	
//	@Test
	public void testGetProductByFilter() {
	}
	
	@Test
	public void testFindAllProduct() {
		productDAO.readAllProducts();
		productDAO.readAllProducts();
		productDAO.readAllProducts();
		
		
	}
	
	
	
}















