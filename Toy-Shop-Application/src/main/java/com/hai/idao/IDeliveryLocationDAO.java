package com.hai.idao;

import java.util.List;

import com.hai.model.DeliveryLocation;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IDeliveryLocationDAO {
	
	public boolean createDeliveryLocation(DeliveryLocation deliveryLocation);
	public DeliveryLocation readDeliveryLocation(int deliveryLocationID);
	public boolean updateDeliveryLocation(DeliveryLocation deliveryLocation);
	public boolean deleteDeliveryLocation(int deliveryLocationID);
	public List<DeliveryLocation> readAllDeliveryLocations();
	public List<DeliveryLocation> readDeliveryLocationByProperty(String name, Object value);
	
}
