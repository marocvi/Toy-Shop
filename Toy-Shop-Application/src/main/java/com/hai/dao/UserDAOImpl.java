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

import com.hai.idao.IUserDAO;
import com.hai.model.Users;

@Repository("UsersDAO")
public class UserDAOImpl implements IUserDAO{
	private Logger LOGGER = Logger.getLogger(UserDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createUsers(Users user) {
		LOGGER.info("Call create Users");
		try {
			sessionFactory.getCurrentSession().persist(user);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Users");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Users readUsers(int userID) {
		LOGGER.info("Call read Users");
		try {
			Users user = sessionFactory.getCurrentSession().get(Users.class, userID);
			return user;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Users");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateUsers(Users user) {
		LOGGER.info("Call update Users");
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Users");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteUsers(int userID) {
		LOGGER.info("Call delete Users");
		try {
			@SuppressWarnings("unchecked")
			Query<Users> query = sessionFactory.getCurrentSession().createQuery("delete from Users where id=:userID");
			query.setParameter("userID", userID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Users");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Users> readAllUserss() {
		LOGGER.info("Call read all Userss");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Users").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Userss");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Users> readUsersByProperty(String name, Object value) {
		LOGGER.info("Call read Users by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Users> criteriaQuery = builder.createQuery(Users.class);
			Root<Users> root = criteriaQuery.from(Users.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Users> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Users by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

	@Override
	@Transactional
	public Users readByEmail(String email) {
		LOGGER.info("Call ready  Users by Email");
		try {
			@SuppressWarnings("unchecked")
			Query<Users> query = sessionFactory.getCurrentSession().createQuery("delete from Users where email=:email");
			query.setParameter("email", email);
			return query.getSingleResult();
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Users");
			return null;
		}
	}


	

		
	
}
