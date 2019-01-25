package com.hai.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hai.idao.IProductPriceDAO;
import com.hai.model.ProductPrice;

@Repository("ProductPriceDAO")
public class ProductPriceDAOImpl implements IProductPriceDAO{
	private Logger LOGGER = Logger.getLogger(ProductPriceDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createProductPrice(ProductPrice price) {
		LOGGER.info("Call create ProductPrice");
		try {
			sessionFactory.getCurrentSession().persist(price);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create ProductPrice");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ProductPrice readProductPrice(int priceID) {
		LOGGER.info("Call read ProductPrice");
		try {
			ProductPrice price = sessionFactory.getCurrentSession().get(ProductPrice.class, priceID);
			return price;
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductPrice");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateProductPrice(ProductPrice price) {
		LOGGER.info("Call update ProductPrice");
		try {
			sessionFactory.getCurrentSession().update(price);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update ProductPrice");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteProductPrice(int priceID) {
		LOGGER.info("Call delete ProductPrice");
		try {
			@SuppressWarnings("unchecked")
			Query<ProductPrice> query = sessionFactory.getCurrentSession().createQuery("delete from ProductPrice where id=:priceID");
			query.setParameter("priceID", priceID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete ProductPrice");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<ProductPrice> readAllProductPrices() {
		LOGGER.info("Call read all ProductPrices");
		try {
			return sessionFactory.getCurrentSession().createQuery("from ProductPrice").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all ProductPrices");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductPrice> readProductPriceByProperty(String name, Object value) {
		LOGGER.info("Call read ProductPrice by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<ProductPrice> criteriaQuery = builder.createQuery(ProductPrice.class);
			Root<ProductPrice> root = criteriaQuery.from(ProductPrice.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<ProductPrice> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductPrice by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
