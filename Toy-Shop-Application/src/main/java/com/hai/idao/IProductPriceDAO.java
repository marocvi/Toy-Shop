package com.hai.idao;

import java.util.List;

import com.hai.model.Price;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IPriceDAO {
	
	public boolean createPrice(Price price);
	public Price readPrice(int priceID);
	public boolean updatePrice(Price price);
	public boolean deletePrice(int priceID);
	public List<Price> readAllPrices();
	public List<Price> readPriceByProperty(String name, Object value);
	
}
