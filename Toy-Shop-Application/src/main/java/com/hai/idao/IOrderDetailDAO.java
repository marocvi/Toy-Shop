package com.hai.idao;

import java.util.List;

import com.hai.model.OrderDetail;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IOrderDetailDAO {
	
	public boolean createOrderDetail(OrderDetail orderDetail);
	public OrderDetail readOrderDetail(int orderDetailID);
	public boolean updateOrderDetail(OrderDetail orderDetail);
	public boolean deleteOrderDetail(int orderDetailID);
	public List<OrderDetail> readAllOrderDetails();
	public List<OrderDetail> readOrderDetailByProperty(String name, Object value);
	
}
