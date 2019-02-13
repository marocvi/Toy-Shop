package com.hai.iservice;

import java.util.List;

import com.hai.model.Product;
import com.hai.model.ProductColor;

public interface IProductColorService {

	public List<ProductColor> findColorsByProduct(Product product); 
}
