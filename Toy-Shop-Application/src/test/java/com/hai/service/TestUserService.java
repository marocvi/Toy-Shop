package com.hai.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.iservice.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestUserService {

	@Autowired
	IUserService userService;
	
//	@Test
	public void testCheckExistEmail() {
		assertFalse(userService.checkExistEmail(""));
	}
	
//	@Test
	public void testGetUser() {
		assertNotNull(userService.getUserByToken("$2a$10$/JVs.6XixZVuXb.PYzoabOu/UGg5NEUkhXFsXp0hqiucHnHU0aGLW"));
	}
	
	@Test
	public void testActivateUser() {
		assertNull(userService.activateUser("$2a$10$/JVs.6XixZVuXb.PYzoabOu/UGg5NEUkhXFsXp0hqiucHnHU0aGLW"));
	}
	
}
