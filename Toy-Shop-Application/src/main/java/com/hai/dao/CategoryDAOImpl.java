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

import com.hai.idao.ICategoryDAO;
import com.hai.model.Category;

@Repository("CategoryDAO")
public class CategoryDAOImpl implements ICategoryDAO{
	private Logger LOGGER = Logger.getLogger(CategoryDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createCategory(Category category) {
		LOGGER.info("Call create Category");
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Category");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Category readCategory(int categoryID) {
		LOGGER.info("Call read Category");
		try {
			Category category = sessionFactory.getCurrentSession().get(Category.class, categoryID);
			return category;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Category");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateCategory(Category category) {
		LOGGER.info("Call update Category");
		try {
			sessionFactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Category");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteCategory(int categoryID) {
		LOGGER.info("Call delete Category");
		try {
			@SuppressWarnings("unchecked")
			Query<Category> query = sessionFactory.getCurrentSession().createQuery("delete from Category where categoryID=:categoryID");
			query.setParameter("categoryID", categoryID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Category");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Category> readAllCategorys() {
		LOGGER.info("Call read all Categorys");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Category").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Categorys");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Category> readCategoryByProperty(String name, Object value) {
		LOGGER.info("Call read Category by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Category> criteriaQuery = builder.createQuery(Category.class);
			Root<Category> root = criteriaQuery.from(Category.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Category> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Category by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
