package com.hai.idao;

import java.util.List;

import com.hai.model.CartDetail;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface ICartDetailDAO {
	
	public boolean createCartDetail(CartDetail cartDetail);
	public CartDetail readCartDetail(int cartDetailID);
	public boolean updateCartDetail(CartDetail cartDetail);
	public boolean deleteCartDetail(int cartDetailID);
	public List<CartDetail> readAllCartDetails();
	public List<CartDetail> readCartDetailByProperty(String name, Object value);
	
}
