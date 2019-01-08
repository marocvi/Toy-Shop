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

import com.hai.idao.IWishlistDAO;
import com.hai.model.Wishlist;

@Repository("WishlistDAO")
public class WishlistDAOImpl implements IWishlistDAO{
	private Logger LOGGER = Logger.getLogger(WishlistDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createWishlist(Wishlist wishlist) {
		LOGGER.info("Call create Wishlist");
		try {
			sessionFactory.getCurrentSession().persist(wishlist);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Wishlist");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Wishlist readWishlist(int wishlistID) {
		LOGGER.info("Call read Wishlist");
		try {
			Wishlist wishlist = sessionFactory.getCurrentSession().get(Wishlist.class, wishlistID);
			return wishlist;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Wishlist");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateWishlist(Wishlist wishlist) {
		LOGGER.info("Call update Wishlist");
		try {
			sessionFactory.getCurrentSession().update(wishlist);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Wishlist");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteWishlist(int wishlistID) {
		LOGGER.info("Call delete Wishlist");
		try {
			@SuppressWarnings("unchecked")
			Query<Wishlist> query = sessionFactory.getCurrentSession().createQuery("delete from Wishlist where id=:wishlistID");
			query.setParameter("wishlistID", wishlistID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Wishlist");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Wishlist> readAllWishlists() {
		LOGGER.info("Call read all Wishlists");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Wishlist").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Wishlists");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Wishlist> readWishlistByProperty(String name, Object value) {
		LOGGER.info("Call read Wishlist by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Wishlist> criteriaQuery = builder.createQuery(Wishlist.class);
			Root<Wishlist> root = criteriaQuery.from(Wishlist.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Wishlist> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Wishlist by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
