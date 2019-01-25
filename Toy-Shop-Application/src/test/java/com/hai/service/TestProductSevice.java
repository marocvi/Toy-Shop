package com.hai.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.command.FilterCommand;
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
		FilterCommand filterCommand = new FilterCommand();
//		System.out.println(filterCommand.getFilterSql());
//		filterCommand.setMinPrice(34);
//		filterCommand.setMaxPrice(1000);
//		filterCommand.setCategory(new String[] {});
//		filterCommand.setPromotion(new int[] {0,10});
//		filterCommand.setReview(new int[] {});
		productService.getProductsByFilter(filterCommand, 0, 10);
		System.out.println("hai");
		productService.getProductsByFilter(filterCommand, 0, 10);
		System.out.println("hai");
		productService.getProductsByFilter(filterCommand, 0, 10);
		System.out.println("hai");
		
//		for (Product product : products) {
//			System.out.println(product.getName());
//		}
	}
	
	@Test
	public void testFindAllProduct() {
		productDAO.readAllProducts();
		productDAO.readAllProducts();
		productDAO.readAllProducts();
		
		
	}
	
	
	
}















