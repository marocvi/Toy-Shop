package com.hai.idao;

import java.util.List;

import com.hai.model.Product;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IProductDAO {
	
	public boolean createProduct(Product product);
	public Product readProduct(int productID);
	public boolean updateProduct(Product product);
	public boolean deleteProduct(int productID);
	public List<Product> readAllProducts();
	public List<Product> readProductByProperty(String name, Object value);
	
}
