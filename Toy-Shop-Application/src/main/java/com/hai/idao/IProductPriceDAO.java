package com.hai.idao;

import java.util.List;

import com.hai.model.ProductPrice;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IProductPriceDAO {
	
	public boolean createProductPrice(ProductPrice price);
	public ProductPrice readProductPrice(int priceID);
	public boolean updateProductPrice(ProductPrice price);
	public boolean deleteProductPrice(int priceID);
	public List<ProductPrice> readAllProductPrices();
	public List<ProductPrice> readProductPriceByProperty(String name, Object value);
	
}
