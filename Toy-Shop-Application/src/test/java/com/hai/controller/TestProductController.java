package com.hai.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.hai.command.FilterCommand;
import com.hai.config.SpringWebContextConfig;
import com.hai.config.TestConfigContext;
import com.hai.config.UtilConfig;
import com.hai.iservice.IProductService;
import com.hai.model.Product;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class,TestConfigContext.class,UtilConfig.class})
@WebAppConfiguration
public class TestProductController {

	private MockMvc mockMVC;
	List<Product> products = new ArrayList<>();
	
	@Autowired
	private IProductService productService;
	
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	
	@Before
	public void setUp() {
		Mockito.reset(productService);
		mockMVC = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
	}
	
	@Test
	public void testProductByDefault() throws Exception {
		products = getListOfProducts();
		FilterCommand filter = new FilterCommand();
		when(productService.getProductsByFilter(filter)).thenReturn(products);
		
		mockMVC.perform(get("/product?page=1")
				.param("page", "1")
				.flashAttr("filterCommand", filter))
		
		.andExpect(status().isOk())
		.andExpect(view().name("product"))
		.andExpect(forwardedUrl("/WEB-INF/views/base/main-layout.jsp"))
		.andExpect(model().attribute("numberOfPages", 1))
		.andExpect(model().attribute("products", products));
		verify(productService, times(1)).getProductsByFilter(filter);
		verifyZeroInteractions(productService);
		mockMVC.perform(get("/product?page=5")).andExpect(view().name("error_404")).andExpect(forwardedUrl("/WEB-INF/views/error/404.jsp"));
		
		
		
	}
	
	public List<Product> getListOfProducts(){
		List<Product> products = new ArrayList<>();
		Product product1 = new Product();
		product1.setName("product1");
		products.add(product1);
		
		Product product2 = new Product();
		product2.setName("product2");
		products.add(product2);
		
		Product product3 = new Product();
		product3.setName("product3");
		products.add(product3);
		
		
		return products;
	}
	
}
