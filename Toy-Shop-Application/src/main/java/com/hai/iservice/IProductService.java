package com.hai.iservice;

import java.util.List;

import com.hai.command.FilterCommand;
import com.hai.model.Product;

/**
 * This interface including functions for interact to products
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IProductService {

	/**
	 * Using filter to filter list of products.
	 * @param list
	 * @param filter
	 * @return
	 */
	public List<Product> getProductsByFilter( FilterCommand filter);
	
	/**
	 * Using product id to look for product
	 * @param productId
	 * @return
	 */
	public Product getPrductById(int productId);
	
	
	/**
	 * This function is using for update to product
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product);
	
	
	
}
