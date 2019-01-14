package com.hai.service;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.iservice.IVerifyAccountTokenService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestVerifyAccountTokenService {

	@Autowired
	IVerifyAccountTokenService accountTokenService;
	
	@Test
	public void testSaveVerifyToken() {
		assertTrue(accountTokenService.saveVerifyToken("123", "kithuathatnhandalat@gmail.com"));
	}
	
}
