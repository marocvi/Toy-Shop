package com.hai.idao;

import java.util.List;

import com.hai.model.ProductImage;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IProductImageDAO {
	
	public boolean createProductImage(ProductImage productImage);
	public ProductImage readProductImage(int productImageID);
	public boolean updateProductImage(ProductImage productImage);
	public boolean deleteProductImage(int productImageID);
	public List<ProductImage> readAllProductImages();
	public List<ProductImage> readProductImageByProperty(String name, Object value);
	
}
