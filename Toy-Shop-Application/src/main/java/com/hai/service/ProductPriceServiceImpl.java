package com.hai.service;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.iservice.IProductPriceService;
import com.hai.model.ProductPrice;

@Service
public class ProductPriceServiceImpl implements IProductPriceService {

	@Autowired
	private  SessionFactory sessionFactory;

	Logger LOGGER = Logger.getLogger(ProductPriceServiceImpl.class);

	@Transactional
	@Override
	public double getCurrentPrice(int productID) {
		LOGGER.info("Call get current price");
		Session sesion = sessionFactory.getCurrentSession();
		try {

			@SuppressWarnings("unchecked")
			Query<ProductPrice> query = sesion.createQuery("from ProductPrice where Product_ID=:productID");
			query.setParameter("productID", productID);
			List<ProductPrice> prices = query.getResultList();
			Double unitPrice = 0.0;
			for (ProductPrice price : prices) {
				if (new Date().after(price.getStartDate()) && new Date().before(price.getEndDate())) {
					unitPrice = price.getUnitPrice();
				}
			}
			if(unitPrice==0.0) {
				LOGGER.warn("There is no valid price for the product");
			}
			return unitPrice;
		} catch (Exception e) {
			LOGGER.error("Can't get price");
			e.printStackTrace();
			return 0.0;
		}
	}
	
	public static double getCurrentPrice(Set<ProductPrice> prices) {
		Double unitPrice = 0.0;
		for (ProductPrice price : prices) {
			if (new Date().after(price.getStartDate()) && new Date().before(price.getEndDate())) {
				unitPrice = price.getUnitPrice();
			}
		}
		return unitPrice;
	}
	
	
}
