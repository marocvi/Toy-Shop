package com.hai.idao;

import java.util.List;

import com.hai.model.ProductColor;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IProductColorDAO {
	
	public boolean createProductColor(ProductColor productColor);
	public ProductColor readProductColor(int productColorID);
	public boolean updateProductColor(ProductColor productColor);
	public boolean deleteProductColor(int productColorID);
	public List<ProductColor> readAllProductColors();
	public List<ProductColor> readProductColorByProperty(String name, Object value);
	
}
