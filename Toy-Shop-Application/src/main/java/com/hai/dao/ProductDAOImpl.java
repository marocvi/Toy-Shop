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

import com.hai.idao.IProductDAO;
import com.hai.model.Product;

@Repository("ProductDAO")
public class ProductDAOImpl implements IProductDAO{
	private Logger LOGGER = Logger.getLogger(ProductDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createProduct(Product product) {
		LOGGER.info("Call create Product");
		try {
			sessionFactory.getCurrentSession().persist(product);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Product");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Product readProduct(int productID) {
		LOGGER.info("Call read Product");
		try {
			Product product = sessionFactory.getCurrentSession().get(Product.class, productID);
			return product;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Product");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateProduct(Product product) {
		LOGGER.info("Call update Product");
		try {
			sessionFactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Product");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteProduct(int productID) {
		LOGGER.info("Call delete Product");
		try {
			@SuppressWarnings("unchecked")
			Query<Product> query = sessionFactory.getCurrentSession().createQuery("delete from Product where productID=:productID");
			query.setParameter("productID", productID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Product");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Product> readAllProducts() {
		LOGGER.info("Call read all Products");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Product").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Products");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Product> readProductByProperty(String name, Object value) {
		LOGGER.info("Call read Product by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Product> criteriaQuery = builder.createQuery(Product.class);
			Root<Product> root = criteriaQuery.from(Product.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Product> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Product by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
