package com.hai.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.idao.ICategoryDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestCategoryDAO {
	
	@Autowired
	ICategoryDAO categoryDAO;
	
	
	@Test
	public void testFindAll() {
		
		categoryDAO.readAllCategorys();
		
		categoryDAO.readAllCategorys();
		categoryDAO.readAllCategorys();
		
	}
//	@Test
	public void testFIndByID() {
		
		categoryDAO.readCategory(1);
		categoryDAO.readCategory(1);
		categoryDAO.readCategory(1);
	}
	
}
