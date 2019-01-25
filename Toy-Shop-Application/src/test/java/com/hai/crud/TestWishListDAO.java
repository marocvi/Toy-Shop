package com.hai.crud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.idao.IWishlistDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestWishListDAO {

	@Autowired
	IWishlistDAO wishListDAO;
	
	
	@Test
	public void testWIshlistDAO() {
		wishListDAO.readAllWishlists();
		wishListDAO.readAllWishlists();
		wishListDAO.readAllWishlists();
	}
}
