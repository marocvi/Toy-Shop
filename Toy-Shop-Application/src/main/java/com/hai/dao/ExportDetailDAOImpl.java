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

import com.hai.idao.IExportDetailDAO;
import com.hai.model.ExportDetail;

@Repository("ExportDetailDAO")
public class ExportDetailDAOImpl implements IExportDetailDAO{
	private Logger LOGGER = Logger.getLogger(ExportDetailDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createExportDetail(ExportDetail exportDetail) {
		LOGGER.info("Call create ExportDetail");
		try {
			sessionFactory.getCurrentSession().persist(exportDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create ExportDetail");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ExportDetail readExportDetail(int exportDetailID) {
		LOGGER.info("Call read ExportDetail");
		try {
			ExportDetail exportDetail = sessionFactory.getCurrentSession().get(ExportDetail.class, exportDetailID);
			return exportDetail;
		}
		catch(Exception e) {
			LOGGER.error("Can't read ExportDetail");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateExportDetail(ExportDetail exportDetail) {
		LOGGER.info("Call update ExportDetail");
		try {
			sessionFactory.getCurrentSession().update(exportDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update ExportDetail");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteExportDetail(int exportDetailID) {
		LOGGER.info("Call delete ExportDetail");
		try {
			@SuppressWarnings("unchecked")
			Query<ExportDetail> query = sessionFactory.getCurrentSession().createQuery("delete from ExportDetail where exportDetailID=:exportDetailID");
			query.setParameter("exportDetailID", exportDetailID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete ExportDetail");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<ExportDetail> readAllExportDetails() {
		LOGGER.info("Call read all ExportDetails");
		try {
			return sessionFactory.getCurrentSession().createQuery("from ExportDetail").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all ExportDetails");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ExportDetail> readExportDetailByProperty(String name, Object value) {
		LOGGER.info("Call read ExportDetail by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<ExportDetail> criteriaQuery = builder.createQuery(ExportDetail.class);
			Root<ExportDetail> root = criteriaQuery.from(ExportDetail.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<ExportDetail> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read ExportDetail by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
