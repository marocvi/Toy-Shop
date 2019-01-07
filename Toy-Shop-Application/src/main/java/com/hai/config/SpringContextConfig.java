package com.hai.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.hai")
public class SpringContextConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver getViewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		return  viewResolver;
	}
	
	@Bean
	public TilesConfigurer getTileConfigurer() {
		TilesConfigurer tileConfigurer = new TilesConfigurer();
		tileConfigurer.setDefinitions("/WEB-INF/config/tile/config-tile.xml");
		return tileConfigurer;
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
