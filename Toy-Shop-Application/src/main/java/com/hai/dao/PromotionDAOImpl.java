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

import com.hai.idao.IPromotionDAO;
import com.hai.model.Promotion;

@Repository("PromotionDAO")
public class PromotionDAOImpl implements IPromotionDAO{
	private Logger LOGGER = Logger.getLogger(PromotionDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createPromotion(Promotion promotion) {
		LOGGER.info("Call create Promotion");
		try {
			sessionFactory.getCurrentSession().persist(promotion);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Promotion");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Promotion readPromotion(int promotionID) {
		LOGGER.info("Call read Promotion");
		try {
			Promotion promotion = sessionFactory.getCurrentSession().get(Promotion.class, promotionID);
			return promotion;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Promotion");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updatePromotion(Promotion promotion) {
		LOGGER.info("Call update Promotion");
		try {
			sessionFactory.getCurrentSession().update(promotion);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Promotion");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deletePromotion(int promotionID) {
		LOGGER.info("Call delete Promotion");
		try {
			@SuppressWarnings("unchecked")
			Query<Promotion> query = sessionFactory.getCurrentSession().createQuery("delete from Promotion where id=:promotionID");
			query.setParameter("promotionID", promotionID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Promotion");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Promotion> readAllPromotions() {
		LOGGER.info("Call read all Promotions");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Promotion").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Promotions");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Promotion> readPromotionByProperty(String name, Object value) {
		LOGGER.info("Call read Promotion by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Promotion> criteriaQuery = builder.createQuery(Promotion.class);
			Root<Promotion> root = criteriaQuery.from(Promotion.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Promotion> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Promotion by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
