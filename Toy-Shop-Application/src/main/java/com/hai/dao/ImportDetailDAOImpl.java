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

import com.hai.idao.IImportDetailDAO;
import com.hai.model.ImportDetail;

@Repository("ImportDetailDAO")
public class ImportDetailDAOImpl implements IImportDetailDAO{
	private Logger LOGGER = Logger.getLogger(ImportDetailDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createImportDetail(ImportDetail importDetail) {
		LOGGER.info("Call create ImportDetail");
		try {
			sessionFactory.getCurrentSession().persist(importDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create ImportDetail");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public ImportDetail readImportDetail(int importDetailID) {
		LOGGER.info("Call read ImportDetail");
		try {
			ImportDetail importDetail = sessionFactory.getCurrentSession().get(ImportDetail.class, importDetailID);
			return importDetail;
		}
		catch(Exception e) {
			LOGGER.error("Can't read ImportDetail");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateImportDetail(ImportDetail importDetail) {
		LOGGER.info("Call update ImportDetail");
		try {
			sessionFactory.getCurrentSession().update(importDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update ImportDetail");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteImportDetail(int importDetailID) {
		LOGGER.info("Call delete ImportDetail");
		try {
			@SuppressWarnings("unchecked")
			Query<ImportDetail> query = sessionFactory.getCurrentSession().createQuery("delete from ImportDetail where importDetailID=:importDetailID");
			query.setParameter("importDetailID", importDetailID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete ImportDetail");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<ImportDetail> readAllImportDetails() {
		LOGGER.info("Call read all ImportDetails");
		try {
			return sessionFactory.getCurrentSession().createQuery("from ImportDetail").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all ImportDetails");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<ImportDetail> readImportDetailByProperty(String name, Object value) {
		LOGGER.info("Call read ImportDetail by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<ImportDetail> criteriaQuery = builder.createQuery(ImportDetail.class);
			Root<ImportDetail> root = criteriaQuery.from(ImportDetail.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<ImportDetail> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read ImportDetail by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
