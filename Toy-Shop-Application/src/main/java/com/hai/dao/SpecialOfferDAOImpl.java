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

import com.hai.idao.ISpecialOfferDAO;
import com.hai.model.SpecialOffer;

@Repository("SpecialOfferDAO")
public class SpecialOfferDAOImpl implements ISpecialOfferDAO{
	private Logger LOGGER = Logger.getLogger(SpecialOfferDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createSpecialOffer(SpecialOffer specialOffer) {
		LOGGER.info("Call create SpecialOffer");
		try {
			sessionFactory.getCurrentSession().persist(specialOffer);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create SpecialOffer");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public SpecialOffer readSpecialOffer(int specialOfferID) {
		LOGGER.info("Call read SpecialOffer");
		try {
			SpecialOffer specialOffer = sessionFactory.getCurrentSession().get(SpecialOffer.class, specialOfferID);
			return specialOffer;
		}
		catch(Exception e) {
			LOGGER.error("Can't read SpecialOffer");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateSpecialOffer(SpecialOffer specialOffer) {
		LOGGER.info("Call update SpecialOffer");
		try {
			sessionFactory.getCurrentSession().update(specialOffer);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update SpecialOffer");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteSpecialOffer(int specialOfferID) {
		LOGGER.info("Call delete SpecialOffer");
		try {
			@SuppressWarnings("unchecked")
			Query<SpecialOffer> query = sessionFactory.getCurrentSession().createQuery("delete from SpecialOffer where id=:specialOfferID");
			query.setParameter("specialOfferID", specialOfferID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete SpecialOffer");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<SpecialOffer> readAllSpecialOffers() {
		LOGGER.info("Call read all SpecialOffers");
		try {
			return sessionFactory.getCurrentSession().createQuery("from SpecialOffer").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all SpecialOffers");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<SpecialOffer> readSpecialOfferByProperty(String name, Object value) {
		LOGGER.info("Call read SpecialOffer by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<SpecialOffer> criteriaQuery = builder.createQuery(SpecialOffer.class);
			Root<SpecialOffer> root = criteriaQuery.from(SpecialOffer.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<SpecialOffer> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read SpecialOffer by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
