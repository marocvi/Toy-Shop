package com.hai.iservice;

import java.util.List;

import com.hai.model.Product;
import com.hai.model.ProductImage;

public interface IProductImageService {

	public List<ProductImage> findImagesByProduct(Product product);
	
}
