package com.hai.crud;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.idao.IUserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestUserDAO {

	@Autowired
	IUserDAO userDAO;
	
	
	@Test
	public void testFindUserByEmail() {
		
		assertNotNull(userDAO.readByEmail("kithuathatnhandalat@gmail.com"));
	}
}
