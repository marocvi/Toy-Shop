package com.hai.idao;

import java.util.List;

import com.hai.model.Cart;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface ICartDAO {
	
	public boolean createCart(Cart cart);
	public Cart readCart(int cartID);
	public boolean updateCart(Cart cart);
	public boolean deleteCart(int cartID);
	public List<Cart> readAllCarts();
	public List<Cart> readCartByProperty(String name, Object value);
	
}
