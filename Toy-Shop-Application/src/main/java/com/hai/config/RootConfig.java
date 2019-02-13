package com.hai.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages="com.hai")
@Import({SpringSecurityContextConfig.class,HibernateConfig.class})

public class RootConfig {
		
	
	@Bean
	public MessageSource messageSource() {
		 ReloadableResourceBundleMessageSource messageResource= new ReloadableResourceBundleMessageSource();
		 messageResource.setBasename("classpath:messages");
		return messageResource;
	}
}
