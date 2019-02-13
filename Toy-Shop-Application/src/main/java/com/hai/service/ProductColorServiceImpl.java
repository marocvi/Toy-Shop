package com.hai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.IProductColorDAO;
import com.hai.iservice.IProductColorService;
import com.hai.model.Product;
import com.hai.model.ProductColor;

@Service
public class ProductColorServiceImpl implements IProductColorService {
	
	@Autowired
	private IProductColorDAO productColorDAO;
	
	
	@Override
	public List<ProductColor> findColorsByProduct(Product product) {
		
		return productColorDAO.readProductColorByProperty("product", product);
	}

}
