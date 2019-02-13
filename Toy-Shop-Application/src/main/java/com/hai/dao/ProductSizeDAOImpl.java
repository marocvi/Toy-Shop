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

import com.hai.idao.IProductSizeDAO;
import com.hai.model.ProductSize;

@Repository("ProductSizeDAO")
public class ProductSizeDAOImpl implements IProductSizeDAO{
	private Logger LOGGER = Logger.getLogger(ProductSizeDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createProductSize(ProductSize productSize) {
		LOGGER.info("Call create ProductSize");
		try {
			sessionFactory.getCurrentSession().persist(productSize);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create ProductSize");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ProductSize readProductSize(int productSizeID) {
		LOGGER.info("Call read ProductSize");
		try {
			ProductSize productSize = sessionFactory.getCurrentSession().get(ProductSize.class, productSizeID);
			return productSize;
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductSize");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateProductSize(ProductSize productSize) {
		LOGGER.info("Call update ProductSize");
		try {
			sessionFactory.getCurrentSession().update(productSize);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update ProductSize");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteProductSize(int productSizeID) {
		LOGGER.info("Call delete ProductSize");
		try {
			@SuppressWarnings("unchecked")
			Query<ProductSize> query = sessionFactory.getCurrentSession().createQuery("delete from ProductSize where id=:productSizeID");
			query.setParameter("productSizeID", productSizeID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete ProductSize");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<ProductSize> readAllProductSizes() {
		LOGGER.info("Call read all ProductSizes");
		try {
			return sessionFactory.getCurrentSession().createQuery("from ProductSize").setCacheable(true).getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all ProductSizes");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductSize> readProductSizeByProperty(String name, Object value) {
		LOGGER.info("Call read ProductSize by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<ProductSize> criteriaQuery = builder.createQuery(ProductSize.class);
			Root<ProductSize> root = criteriaQuery.from(ProductSize.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<ProductSize> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductSize by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
