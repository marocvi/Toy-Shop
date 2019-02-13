package com.hai.idao;

import java.util.List;

import com.hai.model.ProductSize;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IProductSizeDAO {
	
	public boolean createProductSize(ProductSize productSize);
	public ProductSize readProductSize(int productSizeID);
	public boolean updateProductSize(ProductSize productSize);
	public boolean deleteProductSize(int productSizeID);
	public List<ProductSize> readAllProductSizes();
	public List<ProductSize> readProductSizeByProperty(String name, Object value);
	
}
