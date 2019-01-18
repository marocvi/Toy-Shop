package com.hai.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.hai.config.security.MyAuthenticationSucessHandler;

@Configuration
@EnableWebSecurity
public class SpringSecurityContextConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource dataSource;
	@Autowired
	UserDetailsService userDetailService;

	@Override
	@Autowired
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(userDetailService).passwordEncoder(getBCryptEncoder());
		
		
			
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//The pages doesnt require login
		//The pages require role_User
		//The pages require role_Admin
		
		
		//Login config
		  http.authorizeRequests().antMatchers("/admin*").authenticated().antMatchers("/normal*").permitAll()
          .and()
          .formLogin()
          .loginPage("/login?require")
          .loginProcessingUrl("/loginUser")
          .failureUrl("/login?error")
          .usernameParameter("email")
          .passwordParameter("password")
          .and()
          .rememberMe().key("uniqueAndSecret").tokenValiditySeconds(86400)
          .and()
          .csrf().disable();
		  
		//Logout Config
		  http.authorizeRequests().and()
          .logout().deleteCookies("JSESSIONID").logoutSuccessUrl("/login?logout");
		 //Spring social Config
		  
		  
		  
		  
		  
		  
		  
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	/* Bean */
	// Configure encoder
	@Bean
	public BCryptPasswordEncoder getBCryptEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Authentication Manager
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	public AuthenticationSuccessHandler myAuthenticationSucessHandler() {
		return new MyAuthenticationSucessHandler();
	}

}
