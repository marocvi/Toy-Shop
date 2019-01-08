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

import com.hai.idao.IExportDAO;
import com.hai.model.Export;

@Repository("ExportDAO")
public class ExportDAOImpl implements IExportDAO{
	private Logger LOGGER = Logger.getLogger(ExportDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createExport(Export export) {
		LOGGER.info("Call create Export");
		try {
			sessionFactory.getCurrentSession().persist(export);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Export");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Export readExport(int exportID) {
		LOGGER.info("Call read Export");
		try {
			Export export = sessionFactory.getCurrentSession().get(Export.class, exportID);
			return export;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Export");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateExport(Export export) {
		LOGGER.info("Call update Export");
		try {
			sessionFactory.getCurrentSession().update(export);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Export");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteExport(int exportID) {
		LOGGER.info("Call delete Export");
		try {
			@SuppressWarnings("unchecked")
			Query<Export> query = sessionFactory.getCurrentSession().createQuery("delete from Export where id=:exportID");
			query.setParameter("exportID", exportID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Export");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Export> readAllExports() {
		LOGGER.info("Call read all Exports");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Export").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Exports");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Export> readExportByProperty(String name, Object value) {
		LOGGER.info("Call read Export by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Export> criteriaQuery = builder.createQuery(Export.class);
			Root<Export> root = criteriaQuery.from(Export.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Export> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Export by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
