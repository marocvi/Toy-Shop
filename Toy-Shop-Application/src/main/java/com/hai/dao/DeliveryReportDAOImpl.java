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

import com.hai.idao.IDeliveryReportDAO;
import com.hai.model.DeliveryReport;

@Repository("DeliveryReportDAO")
public class DeliveryReportDAOImpl implements IDeliveryReportDAO{
	private Logger LOGGER = Logger.getLogger(DeliveryReportDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createDeliveryReport(DeliveryReport deliveryReport) {
		LOGGER.info("Call create DeliveryReport");
		try {
			sessionFactory.getCurrentSession().persist(deliveryReport);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create DeliveryReport");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public DeliveryReport readDeliveryReport(int deliveryReportID) {
		LOGGER.info("Call read DeliveryReport");
		try {
			DeliveryReport deliveryReport = sessionFactory.getCurrentSession().get(DeliveryReport.class, deliveryReportID);
			return deliveryReport;
		}
		catch(Exception e) {
			LOGGER.error("Can't read DeliveryReport");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateDeliveryReport(DeliveryReport deliveryReport) {
		LOGGER.info("Call update DeliveryReport");
		try {
			sessionFactory.getCurrentSession().update(deliveryReport);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update DeliveryReport");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteDeliveryReport(int deliveryReportID) {
		LOGGER.info("Call delete DeliveryReport");
		try {
			@SuppressWarnings("unchecked")
			Query<DeliveryReport> query = sessionFactory.getCurrentSession().createQuery("delete from DeliveryReport where id=:deliveryReportID");
			query.setParameter("deliveryReportID", deliveryReportID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete DeliveryReport");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<DeliveryReport> readAllDeliveryReports() {
		LOGGER.info("Call read all DeliveryReports");
		try {
			return sessionFactory.getCurrentSession().createQuery("from DeliveryReport").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all DeliveryReports");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<DeliveryReport> readDeliveryReportByProperty(String name, Object value) {
		LOGGER.info("Call read DeliveryReport by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<DeliveryReport> criteriaQuery = builder.createQuery(DeliveryReport.class);
			Root<DeliveryReport> root = criteriaQuery.from(DeliveryReport.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<DeliveryReport> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read DeliveryReport by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
