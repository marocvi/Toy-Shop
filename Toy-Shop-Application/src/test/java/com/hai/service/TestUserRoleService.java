package com.hai.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.iservice.IUserRoleService;
import com.hai.iservice.IUserService;
import com.hai.model.Role.Roles;
import com.hai.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestUserRoleService {

	@Autowired
	IUserRoleService userRoleService;
	
	@Autowired
	IUserService userService;
	
	
	@Test
	public void testSaveUserRole() {
		Users user = userService.getUserByToken("$2a$10$BY0bsj/CT/0iNFQvZu9jJueM2mzcYvnypr9n9qVOMlSJLXBCyk.Ym");
		
		userRoleService.saveUserRole(user, Roles.USER);
		
	
	}
	
	
}
