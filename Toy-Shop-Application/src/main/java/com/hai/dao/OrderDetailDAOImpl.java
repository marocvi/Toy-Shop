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

import com.hai.idao.IOrderDetailDAO;
import com.hai.model.OrderDetail;

@Repository("OrderDetailDAO")
public class OrderDetailDAOImpl implements IOrderDetailDAO{
	private Logger LOGGER = Logger.getLogger(OrderDetailDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createOrderDetail(OrderDetail orderDetail) {
		LOGGER.info("Call create OrderDetail");
		try {
			sessionFactory.getCurrentSession().persist(orderDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create OrderDetail");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public OrderDetail readOrderDetail(int orderDetailID) {
		LOGGER.info("Call read OrderDetail");
		try {
			OrderDetail orderDetail = sessionFactory.getCurrentSession().get(OrderDetail.class, orderDetailID);
			return orderDetail;
		}
		catch(Exception e) {
			LOGGER.error("Can't read OrderDetail");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateOrderDetail(OrderDetail orderDetail) {
		LOGGER.info("Call update OrderDetail");
		try {
			sessionFactory.getCurrentSession().update(orderDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update OrderDetail");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteOrderDetail(int orderDetailID) {
		LOGGER.info("Call delete OrderDetail");
		try {
			@SuppressWarnings("unchecked")
			Query<OrderDetail> query = sessionFactory.getCurrentSession().createQuery("delete from OrderDetail where id=:orderDetailID");
			query.setParameter("orderDetailID", orderDetailID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete OrderDetail");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<OrderDetail> readAllOrderDetails() {
		LOGGER.info("Call read all OrderDetails");
		try {
			return sessionFactory.getCurrentSession().createQuery("from OrderDetail").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all OrderDetails");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<OrderDetail> readOrderDetailByProperty(String name, Object value) {
		LOGGER.info("Call read OrderDetail by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<OrderDetail> criteriaQuery = builder.createQuery(OrderDetail.class);
			Root<OrderDetail> root = criteriaQuery.from(OrderDetail.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<OrderDetail> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read OrderDetail by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
