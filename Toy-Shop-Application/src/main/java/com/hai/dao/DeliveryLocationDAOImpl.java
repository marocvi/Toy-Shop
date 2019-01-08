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

import com.hai.idao.IDeliveryLocationDAO;
import com.hai.model.DeliveryLocation;

@Repository("DeliveryLocationDAO")
public class DeliveryLocationDAOImpl implements IDeliveryLocationDAO{
	private Logger LOGGER = Logger.getLogger(DeliveryLocationDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createDeliveryLocation(DeliveryLocation deliveryLocation) {
		LOGGER.info("Call create DeliveryLocation");
		try {
			sessionFactory.getCurrentSession().persist(deliveryLocation);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create DeliveryLocation");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public DeliveryLocation readDeliveryLocation(int deliveryLocationID) {
		LOGGER.info("Call read DeliveryLocation");
		try {
			DeliveryLocation deliveryLocation = sessionFactory.getCurrentSession().get(DeliveryLocation.class, deliveryLocationID);
			return deliveryLocation;
		}
		catch(Exception e) {
			LOGGER.error("Can't read DeliveryLocation");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateDeliveryLocation(DeliveryLocation deliveryLocation) {
		LOGGER.info("Call update DeliveryLocation");
		try {
			sessionFactory.getCurrentSession().update(deliveryLocation);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update DeliveryLocation");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteDeliveryLocation(int deliveryLocationID) {
		LOGGER.info("Call delete DeliveryLocation");
		try {
			@SuppressWarnings("unchecked")
			Query<DeliveryLocation> query = sessionFactory.getCurrentSession().createQuery("delete from DeliveryLocation where id=:deliveryLocationID");
			query.setParameter("deliveryLocationID", deliveryLocationID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete DeliveryLocation");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<DeliveryLocation> readAllDeliveryLocations() {
		LOGGER.info("Call read all DeliveryLocations");
		try {
			return sessionFactory.getCurrentSession().createQuery("from DeliveryLocation").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all DeliveryLocations");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<DeliveryLocation> readDeliveryLocationByProperty(String name, Object value) {
		LOGGER.info("Call read DeliveryLocation by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<DeliveryLocation> criteriaQuery = builder.createQuery(DeliveryLocation.class);
			Root<DeliveryLocation> root = criteriaQuery.from(DeliveryLocation.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<DeliveryLocation> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read DeliveryLocation by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
