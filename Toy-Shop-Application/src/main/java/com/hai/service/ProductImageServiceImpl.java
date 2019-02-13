package com.hai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.IProductImageDAO;
import com.hai.iservice.IProductImageService;
import com.hai.model.Product;
import com.hai.model.ProductImage;

@Service
public class ProductImageServiceImpl implements IProductImageService {
	@Autowired
	private IProductImageDAO productDAO;
	
	@Override
	public List<ProductImage> findImagesByProduct(Product product) {
		
		return productDAO.readProductImageByProperty("product", product);
	}

}
