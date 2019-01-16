package com.hai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;
import org.springframework.social.security.AuthenticationNameUserIdSource;

@Configuration
@EnableSocial
@PropertySource("classpath:Social-Config.properties")
public class MySocialConfigurer implements SocialConfigurer  {

	@Override
	public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer,
			Environment env) {
		//Facebook
		FacebookConnectionFactory ffactory = new FacebookConnectionFactory(env.getProperty("facebook.app.id"), env.getProperty("facebook.app.secret"));
		
		connectionFactoryConfigurer.addConnectionFactory(ffactory);
	}

	@Override
	public UserIdSource getUserIdSource() {
		// TODO Auto-generated method stub
		return new AuthenticationNameUserIdSource();
	}

	@Override
	public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator) {
		// TODO Auto-generated method stub
		return null;
	}

}
