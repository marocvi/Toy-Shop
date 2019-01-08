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

import com.hai.idao.IOrderDAO;
import com.hai.model.Order;

@Repository("OrderDAO")
public class OrderDAOImpl implements IOrderDAO{
	private Logger LOGGER = Logger.getLogger(OrderDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createOrder(Order order) {
		LOGGER.info("Call create Order");
		try {
			sessionFactory.getCurrentSession().persist(order);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Order");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Order readOrder(int orderID) {
		LOGGER.info("Call read Order");
		try {
			Order order = sessionFactory.getCurrentSession().get(Order.class, orderID);
			return order;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Order");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateOrder(Order order) {
		LOGGER.info("Call update Order");
		try {
			sessionFactory.getCurrentSession().update(order);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Order");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteOrder(int orderID) {
		LOGGER.info("Call delete Order");
		try {
			@SuppressWarnings("unchecked")
			Query<Order> query = sessionFactory.getCurrentSession().createQuery("delete from Order where id=:orderID");
			query.setParameter("orderID", orderID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Order");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Order> readAllOrders() {
		LOGGER.info("Call read all Orders");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Order").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Orders");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Order> readOrderByProperty(String name, Object value) {
		LOGGER.info("Call read Order by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Order> criteriaQuery = builder.createQuery(Order.class);
			Root<Order> root = criteriaQuery.from(Order.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Order> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Order by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
