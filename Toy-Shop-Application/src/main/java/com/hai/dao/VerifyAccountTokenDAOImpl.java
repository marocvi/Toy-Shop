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

import com.hai.idao.IVerifyAccountTokenDAO;
import com.hai.model.VerifyAccountToken;

@Repository("VerifyAccountTokenDAO")
public class VerifyAccountTokenDAOImpl implements IVerifyAccountTokenDAO{
	private Logger LOGGER = Logger.getLogger(VerifyAccountTokenDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createVerifyAccountToken(VerifyAccountToken verifyAccountToken) {
		LOGGER.info("Call create VerifyAccountToken");
		try {
			sessionFactory.getCurrentSession().persist(verifyAccountToken);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create VerifyAccountToken");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public VerifyAccountToken readVerifyAccountToken(int verifyAccountTokenID) {
		LOGGER.info("Call read VerifyAccountToken");
		try {
			VerifyAccountToken verifyAccountToken = sessionFactory.getCurrentSession().get(VerifyAccountToken.class, verifyAccountTokenID);
			return verifyAccountToken;
		}
		catch(Exception e) {
			LOGGER.error("Can't read VerifyAccountToken");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateVerifyAccountToken(VerifyAccountToken verifyAccountToken) {
		LOGGER.info("Call update VerifyAccountToken");
		try {
			sessionFactory.getCurrentSession().update(verifyAccountToken);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update VerifyAccountToken");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteVerifyAccountToken(int verifyAccountTokenID) {
		LOGGER.info("Call delete VerifyAccountToken");
		try {
			@SuppressWarnings("unchecked")
			Query<VerifyAccountToken> query = sessionFactory.getCurrentSession().createQuery("delete from VerifyAccountToken where id=:verifyAccountTokenID");
			query.setParameter("verifyAccountTokenID", verifyAccountTokenID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete VerifyAccountToken");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<VerifyAccountToken> readAllVerifyAccountTokens() {
		LOGGER.info("Call read all VerifyAccountTokens");
		try {
			return sessionFactory.getCurrentSession().createQuery("from VerifyAccountToken").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all VerifyAccountTokens");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<VerifyAccountToken> readVerifyAccountTokenByProperty(String name, Object value) {
		LOGGER.info("Call read VerifyAccountToken by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<VerifyAccountToken> criteriaQuery = builder.createQuery(VerifyAccountToken.class);
			Root<VerifyAccountToken> root = criteriaQuery.from(VerifyAccountToken.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<VerifyAccountToken> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read VerifyAccountToken by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
