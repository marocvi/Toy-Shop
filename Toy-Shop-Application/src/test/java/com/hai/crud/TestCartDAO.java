package com.hai.crud;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hai.config.SpringWebContextConfig;
import com.hai.idao.ICartDAO;
import com.hai.model.Cart;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes= {SpringWebContextConfig.class})
@WebAppConfiguration
public class TestCartDAO {
	
	@Autowired
	ICartDAO cartDAO ;
	
	@Autowired
	SessionFactory sessionFactory;
	 
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
	
	@Test
	public void testFindByID() {
		assertNotNull(cartDAO.readCart(2));
		assertNotNull(cartDAO.readCart(2));
		assertNotNull(cartDAO.readCart(2));
	}
	
//	@Test
	public void testFindAll() {
		cartDAO.readAllCarts();
		System.out.println("hai");
		cartDAO.readAllCarts();
		System.out.println("hai");
		cartDAO.readAllCarts();
		System.out.println("hai");
		cartDAO.readAllCarts();
		System.out.println("hai");
		
		
	}
	
//	@Test
	public void testFindByProperty(){
		assertEquals(1, cartDAO.readCartByProperty("moneyTotal",12.0).size());
	}
	
//	@Test
	public void testDeleteCart() {
		assertTrue(cartDAO.deleteCart(1));
		
	}
	
}
