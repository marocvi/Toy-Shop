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

import com.hai.idao.ICartDAO;
import com.hai.model.Cart;

@Repository("CartDAO")
public class CartDAOImpl implements ICartDAO{
	private Logger LOGGER = Logger.getLogger(CartDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createCart(Cart cart) {
		LOGGER.info("Call create Cart");
		try {
			sessionFactory.getCurrentSession().persist(cart);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Cart");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Cart readCart(int cartID) {
		LOGGER.info("Call read Cart");
		try {
			Cart cart = sessionFactory.getCurrentSession().get(Cart.class, cartID);
			return cart;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Cart");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateCart(Cart cart) {
		LOGGER.info("Call update Cart");
		try {
			sessionFactory.getCurrentSession().update(cart);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Cart");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteCart(int cartID) {
		LOGGER.info("Call delete Cart");
		try {
			@SuppressWarnings("unchecked")
			Query<Cart> query = sessionFactory.getCurrentSession().createQuery("delete from Cart where cartID=:cartID");
			query.setParameter("cartID", cartID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Cart");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Cart> readAllCarts() {
		LOGGER.info("Call read all Carts");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Cart").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Carts");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Cart> readCartByProperty(String name, Object value) {
		LOGGER.info("Call read Cart by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Cart> criteriaQuery = builder.createQuery(Cart.class);
			Root<Cart> root = criteriaQuery.from(Cart.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Cart> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Cart by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
