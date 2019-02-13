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

import com.hai.idao.IProductImageDAO;
import com.hai.model.ProductImage;

@Repository("ProductImageDAO")
public class ProductImageDAOImpl implements IProductImageDAO{
	private Logger LOGGER = Logger.getLogger(ProductImageDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createProductImage(ProductImage productImage) {
		LOGGER.info("Call create ProductImage");
		try {
			sessionFactory.getCurrentSession().persist(productImage);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create ProductImage");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ProductImage readProductImage(int productImageID) {
		LOGGER.info("Call read ProductImage");
		try {
			ProductImage productImage = sessionFactory.getCurrentSession().get(ProductImage.class, productImageID);
			return productImage;
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductImage");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateProductImage(ProductImage productImage) {
		LOGGER.info("Call update ProductImage");
		try {
			sessionFactory.getCurrentSession().update(productImage);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update ProductImage");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteProductImage(int productImageID) {
		LOGGER.info("Call delete ProductImage");
		try {
			@SuppressWarnings("unchecked")
			Query<ProductImage> query = sessionFactory.getCurrentSession().createQuery("delete from ProductImage where id=:productImageID");
			query.setParameter("productImageID", productImageID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete ProductImage");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<ProductImage> readAllProductImages() {
		LOGGER.info("Call read all ProductImages");
		try {
			return sessionFactory.getCurrentSession().createQuery("from ProductImage").setCacheable(true).getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all ProductImages");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductImage> readProductImageByProperty(String name, Object value) {
		LOGGER.info("Call read ProductImage by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<ProductImage> criteriaQuery = builder.createQuery(ProductImage.class);
			Root<ProductImage> root = criteriaQuery.from(ProductImage.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<ProductImage> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductImage by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
