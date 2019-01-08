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

import com.hai.idao.IPaymentDAO;
import com.hai.model.Payment;

@Repository("PaymentDAO")
public class PaymentDAOImpl implements IPaymentDAO{
	private Logger LOGGER = Logger.getLogger(PaymentDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createPayment(Payment payment) {
		LOGGER.info("Call create Payment");
		try {
			sessionFactory.getCurrentSession().persist(payment);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Payment");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Payment readPayment(int paymentID) {
		LOGGER.info("Call read Payment");
		try {
			Payment payment = sessionFactory.getCurrentSession().get(Payment.class, paymentID);
			return payment;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Payment");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updatePayment(Payment payment) {
		LOGGER.info("Call update Payment");
		try {
			sessionFactory.getCurrentSession().update(payment);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Payment");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deletePayment(int paymentID) {
		LOGGER.info("Call delete Payment");
		try {
			@SuppressWarnings("unchecked")
			Query<Payment> query = sessionFactory.getCurrentSession().createQuery("delete from Payment where paymentID=:paymentID");
			query.setParameter("paymentID", paymentID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Payment");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Payment> readAllPayments() {
		LOGGER.info("Call read all Payments");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Payment").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Payments");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Payment> readPaymentByProperty(String name, Object value) {
		LOGGER.info("Call read Payment by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Payment> criteriaQuery = builder.createQuery(Payment.class);
			Root<Payment> root = criteriaQuery.from(Payment.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Payment> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Payment by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
