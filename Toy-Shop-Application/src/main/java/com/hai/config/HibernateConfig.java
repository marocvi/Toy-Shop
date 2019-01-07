package com.hai.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages="com.hai.model")
@EnableTransactionManagement
public class HibernateConfig {

	
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		
		return dataSource;
		
	}
	
	
}
