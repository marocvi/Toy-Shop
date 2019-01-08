package com.hai.idao;

import java.util.List;

import com.hai.model.Order;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IOrderDAO {
	
	public boolean createOrder(Order crder);
	public Order readOrder(int crderID);
	public boolean updateOrder(Order crder);
	public boolean deleteOrder(int crderID);
	public List<Order> readAllOrders();
	public List<Order> readOrderByProperty(String name, Object value);
	
}
