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

import com.hai.idao.IPriceDAO;
import com.hai.model.Price;

@Repository("PriceDAO")
public class PriceDAOImpl implements IPriceDAO{
	private Logger LOGGER = Logger.getLogger(PriceDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createPrice(Price price) {
		LOGGER.info("Call create Price");
		try {
			sessionFactory.getCurrentSession().persist(price);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Price");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Price readPrice(int priceID) {
		LOGGER.info("Call read Price");
		try {
			Price price = sessionFactory.getCurrentSession().get(Price.class, priceID);
			return price;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Price");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updatePrice(Price price) {
		LOGGER.info("Call update Price");
		try {
			sessionFactory.getCurrentSession().update(price);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Price");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deletePrice(int priceID) {
		LOGGER.info("Call delete Price");
		try {
			@SuppressWarnings("unchecked")
			Query<Price> query = sessionFactory.getCurrentSession().createQuery("delete from Price where id=:priceID");
			query.setParameter("priceID", priceID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Price");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Price> readAllPrices() {
		LOGGER.info("Call read all Prices");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Price").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Prices");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Price> readPriceByProperty(String name, Object value) {
		LOGGER.info("Call read Price by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Price> criteriaQuery = builder.createQuery(Price.class);
			Root<Price> root = criteriaQuery.from(Price.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Price> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Price by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
