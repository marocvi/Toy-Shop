package com.hai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.IProductSizeDAO;
import com.hai.iservice.IProductSizeService;
import com.hai.model.Product;
import com.hai.model.ProductSize;

@Service
public class ProductSizeServiceImpl implements IProductSizeService {
	@Autowired
	private IProductSizeDAO productSizeDAO;
	
	
	@Override
	public List<ProductSize> findSizesByProduct(Product product) {
		return productSizeDAO.readProductSizeByProperty("product", product);
	}

}
