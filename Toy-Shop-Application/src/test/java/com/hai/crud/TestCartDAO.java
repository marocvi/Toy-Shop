package com.hai.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringContextConfig;
import com.hai.idao.ICartDAO;
import com.hai.model.Cart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringContextConfig.class})
@WebAppConfiguration
public class TestCart {
	
	@Autowired
	ICartDAO cartDAO ;
	 
//	@Test
	public void testCreate() {
		Cart cart = new Cart();
		cart.setMoneyTotal(14);
		assertTrue(cartDAO.createCart(cart));
	}
//	@Test 
	public void testUpdate() {
		Cart cart = cartDAO.readCart(1);
		cart.setMoneyTotal(12);
		assertTrue(cartDAO.updateCart(cart));
	}
	
//	@Test
	public void testFindByID() {
		assertNotNull(cartDAO.readCart(1));
	}
	
//	@Test
	public void testFindAll() {
		assertEquals(2, cartDAO.readAllCarts().size());;
	}
	
	@Test
	public void testFindByProperty(){
		assertEquals(1, cartDAO.readCartByProperty("moneyTotal",12.0).size());
	}
	
}
