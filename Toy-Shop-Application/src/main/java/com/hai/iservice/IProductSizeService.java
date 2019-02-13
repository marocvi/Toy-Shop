package com.hai.iservice;

import java.util.List;

import com.hai.model.Product;
import com.hai.model.ProductSize;

public interface IProductSizeService {
	
	public List<ProductSize> findSizesByProduct(Product product);

}
