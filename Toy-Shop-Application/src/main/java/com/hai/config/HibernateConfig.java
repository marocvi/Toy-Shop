package com.hai.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "com.hai.model")
@EnableTransactionManagement
public class HibernateConfig {
	private final Logger LOGGER = Logger.getLogger(HibernateConfig.class);
	@Value("${hibernate.connection.url}")
	private String dbURL;
	@Value("${hibernate.connection.driver_class}")
	private String driver;
	@Value("${hibernate.connection.username}")
	private String username;
	@Value("${hibernate.connection.password}")
	private String password;

	@Value("${hibernate.dialect}")
	private String dialect;
	@Value("${show_sql}")
	private String showSQL;
	@Value("${hibernate.format_sql}")
	private String formaSQL;
	@Value("${hbm2ddl.auto}")
	private String hbm2ddl;
	

	@Bean
	public DataSource getDataSource() {
		System.out.println("HibernateConfig [dbURL=" + dbURL + ", driver=" + driver + ", username=" + username + ", password="
				+ password + ", dialect=" + dialect + ", showSQL=" + showSQL + ", formaSQL=" + formaSQL + ", hbm2ddl="
				+ hbm2ddl + "]");
		LOGGER.info("Create Datasource");
		
		BasicDataSource dataSource =new BasicDataSource();
		dataSource.setDriverClassName(driver);
		dataSource.setUrl(dbURL);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		return dataSource;
	}

	
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource) {
		LOGGER.info("Create SessionFactory");
		LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getProperties());
		builder.scanPackages("com.hai.model");
		return builder.buildSessionFactory();
	}
	private Properties getProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", dialect);
		properties.put("hibernate.hbm2ddl.auto", hbm2ddl);
		properties.put("hibernate.format_sql", formaSQL);
		properties.put("hibernate.show_sql", showSQL);
		return properties;
	}


	@Bean
	public PlatformTransactionManager  getHibernateTransactionManager(SessionFactory sessionFactory) {
		LOGGER.info("Create Transaction Manager");
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		return transactionManager;
	}

}
