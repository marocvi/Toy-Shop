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

import com.hai.idao.IReviewDAO;
import com.hai.model.Review;

@Repository("ReviewDAO")
public class ReviewDAOImpl implements IReviewDAO{
	private Logger LOGGER = Logger.getLogger(ReviewDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createReview(Review review) {
		LOGGER.info("Call create Review");
		try {
			sessionFactory.getCurrentSession().persist(review);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Review");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Review readReview(int reviewID) {
		LOGGER.info("Call read Review");
		try {
			Review review = sessionFactory.getCurrentSession().get(Review.class, reviewID);
			return review;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Review");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateReview(Review review) {
		LOGGER.info("Call update Review");
		try {
			sessionFactory.getCurrentSession().update(review);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Review");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteReview(int reviewID) {
		LOGGER.info("Call delete Review");
		try {
			@SuppressWarnings("unchecked")
			Query<Review> query = sessionFactory.getCurrentSession().createQuery("delete from Review where id=:reviewID");
			query.setParameter("reviewID", reviewID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Review");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Review> readAllReviews() {
		LOGGER.info("Call read all Reviews");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Review").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Reviews");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Review> readReviewByProperty(String name, Object value) {
		LOGGER.info("Call read Review by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Review> criteriaQuery = builder.createQuery(Review.class);
			Root<Review> root = criteriaQuery.from(Review.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Review> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Review by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
