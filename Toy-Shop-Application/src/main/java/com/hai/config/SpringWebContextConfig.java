package com.hai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"com.hai.controller","com.hai.model","com.hai.idao","com.hai.iservice","co.hai.exception"
		,"com.hai.tag","com.hai.util","com.hai.validation","com.hai.command"})
public class SpringWebContextConfig extends WebMvcConfigurerAdapter {

	//Config view resolver
	@Bean
	public ViewResolver getViewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		return  viewResolver;
	}
	
	//Config spring tile
	@Bean
	public TilesConfigurer getTileConfigurer() {
		TilesConfigurer tileConfigurer = new TilesConfigurer();
		tileConfigurer.setDefinitions("/WEB-INF/config/tile/config-tile.xml");
		return tileConfigurer;
	}
	
	@Bean
	public SimpleMappingExceptionResolver getExceptionResolver() {
		
		SimpleMappingExceptionResolver exceptionResolver = new SimpleMappingExceptionResolver();
		
		return exceptionResolver;
		
	}

	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//Config static resource.
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/theme/");
	}
	
	
	
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
}
