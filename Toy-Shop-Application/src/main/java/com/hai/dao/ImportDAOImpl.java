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

import com.hai.idao.IImportDAO;
import com.hai.model.Import;

@Repository("ImportDAO")
public class ImportDAOImpl implements IImportDAO{
	private Logger LOGGER = Logger.getLogger(ImportDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createImport(Import imports) {
		LOGGER.info("Call create Import");
		try {
			sessionFactory.getCurrentSession().persist(imports);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Import");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Import readImport(int importsID) {
		LOGGER.info("Call read Import");
		try {
			Import imports = sessionFactory.getCurrentSession().get(Import.class, importsID);
			return imports;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Import");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateImport(Import imports) {
		LOGGER.info("Call update Import");
		try {
			sessionFactory.getCurrentSession().update(imports);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Import");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteImport(int importsID) {
		LOGGER.info("Call delete Import");
		try {
			@SuppressWarnings("unchecked")
			Query<Import> query = sessionFactory.getCurrentSession().createQuery("delete from Import where id=:importsID");
			query.setParameter("importsID", importsID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Import");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Import> readAllImports() {
		LOGGER.info("Call read all Imports");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Import").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Imports");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Import> readImportByProperty(String name, Object value) {
		LOGGER.info("Call read Import by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Import> criteriaQuery = builder.createQuery(Import.class);
			Root<Import> root = criteriaQuery.from(Import.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Import> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Import by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
