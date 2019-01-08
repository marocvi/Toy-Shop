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

import com.hai.idao.ICartDetailDAO;
import com.hai.model.CartDetail;

@Repository("CartDetailDAO")
public class CartDetailDAOImpl implements ICartDetailDAO{
	private Logger LOGGER = Logger.getLogger(CartDetailDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createCartDetail(CartDetail cartDetail) {
		LOGGER.info("Call create CartDetail");
		try {
			sessionFactory.getCurrentSession().persist(cartDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create CartDetail");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public CartDetail readCartDetail(int cartDetailID) {
		LOGGER.info("Call read CartDetail");
		try {
			CartDetail cartDetail = sessionFactory.getCurrentSession().get(CartDetail.class, cartDetailID);
			return cartDetail;
		}
		catch(Exception e) {
			LOGGER.error("Can't read CartDetail");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateCartDetail(CartDetail cartDetail) {
		LOGGER.info("Call update CartDetail");
		try {
			sessionFactory.getCurrentSession().update(cartDetail);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update CartDetail");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteCartDetail(int cartDetailID) {
		LOGGER.info("Call delete CartDetail");
		try {
			@SuppressWarnings("unchecked")
			Query<CartDetail> query = sessionFactory.getCurrentSession().createQuery("delete from CartDetail where id=:cartDetailID");
			query.setParameter("cartDetailID", cartDetailID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete CartDetail");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<CartDetail> readAllCartDetails() {
		LOGGER.info("Call read all CartDetails");
		try {
			return sessionFactory.getCurrentSession().createQuery("from CartDetail").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all CartDetails");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<CartDetail> readCartDetailByProperty(String name, Object value) {
		LOGGER.info("Call read CartDetail by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<CartDetail> criteriaQuery = builder.createQuery(CartDetail.class);
			Root<CartDetail> root = criteriaQuery.from(CartDetail.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<CartDetail> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read CartDetail by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
