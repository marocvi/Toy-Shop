package com.hai.config;

import static org.mockito.Mockito.mock;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

import com.hai.iservice.IProductService;
import com.hai.service.ProductServiceImpl;
//@Configuration
@ComponentScan(basePackages="com.hai",excludeFilters=@Filter(type=FilterType.ASSIGNABLE_TYPE,classes= {RootConfig.class,ProductServiceImpl.class}))
public class TestConfigContext {
	
	
	//Config mock IproductService for testing purpose
	@Bean(name="mockProductService")
	public IProductService getProductService() {
		return mock(IProductService.class);
	}


}
