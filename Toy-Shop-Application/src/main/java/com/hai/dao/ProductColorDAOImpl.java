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

import com.hai.idao.IProductColorDAO;
import com.hai.model.ProductColor;

@Repository("ProductColorDAO")
public class ProductColorDAOImpl implements IProductColorDAO{
	private Logger LOGGER = Logger.getLogger(ProductColorDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createProductColor(ProductColor productColor) {
		LOGGER.info("Call create ProductColor");
		try {
			sessionFactory.getCurrentSession().persist(productColor);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create ProductColor");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ProductColor readProductColor(int productColorID) {
		LOGGER.info("Call read ProductColor");
		try {
			ProductColor productColor = sessionFactory.getCurrentSession().get(ProductColor.class, productColorID);
			return productColor;
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductColor");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateProductColor(ProductColor productColor) {
		LOGGER.info("Call update ProductColor");
		try {
			sessionFactory.getCurrentSession().update(productColor);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update ProductColor");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteProductColor(int productColorID) {
		LOGGER.info("Call delete ProductColor");
		try {
			@SuppressWarnings("unchecked")
			Query<ProductColor> query = sessionFactory.getCurrentSession().createQuery("delete from ProductColor where id=:productColorID");
			query.setParameter("productColorID", productColorID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete ProductColor");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<ProductColor> readAllProductColors() {
		LOGGER.info("Call read all ProductColors");
		try {
			return sessionFactory.getCurrentSession().createQuery("from ProductColor").setCacheable(true).getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all ProductColors");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ProductColor> readProductColorByProperty(String name, Object value) {
		LOGGER.info("Call read ProductColor by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<ProductColor> criteriaQuery = builder.createQuery(ProductColor.class);
			Root<ProductColor> root = criteriaQuery.from(ProductColor.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<ProductColor> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read ProductColor by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
