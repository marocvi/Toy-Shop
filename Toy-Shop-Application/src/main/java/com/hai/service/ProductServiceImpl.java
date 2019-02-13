package com.hai.service;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.command.FilterCommand;
import com.hai.idao.IProductDAO;
import com.hai.iservice.IProductService;
import com.hai.model.Product;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	public SessionFactory sessionFactory;

	@Autowired
	private IProductDAO productDAO;

	Logger LOGGER = Logger.getLogger(ProductServiceImpl.class);



	@Override
	public List<Product> getProductsByFilter(FilterCommand filter) {
		LOGGER.info("Call Get list of products by filter");
		List<Product> products = productDAO.readAllProducts();
		// Check wether filter is empty
		if (filter.isEmpty()) {
			return products;
		} else {
			// Apply price filter
			if (filter.getMaxPrice() != filter.getMinPrice()) {
				products =  products.stream().filter(filter::applyPriceCondition).collect(Collectors.toList());
			}
			// Apply category(discount) filter
			if(filter.getCategory().length!=0) {
				products = products.stream().filter(filter::applyCategoryCondition).collect(Collectors.toList());
			}
			//Apply promotion filter
			if(filter.getPromotion().length!=0) {
				products = products.stream().filter(filter::applyPromotionCondition).collect(Collectors.toList());
			}
			
			//Apply review filter
			if(filter.getReview().length!=0) {
				products = products.stream().filter(filter::applyReviewCondition).collect(Collectors.toList());
			}
			
		}

		// Limit the result
		return products;

	}



	@Override
	public Product getPrductById(int productId) {
		return productDAO.readProduct(productId);
	}



	@Override
	public boolean updateProduct(Product product) {
		return productDAO.updateProduct(product);
	}

}
