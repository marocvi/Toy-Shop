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

import com.hai.idao.IUserRoleDAO;
import com.hai.model.UserRole;

@Repository("UserRoleDAO")
public class UserRoleDAOImpl implements IUserRoleDAO{
	private Logger LOGGER = Logger.getLogger(UserRoleDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createUserRole(UserRole userRole) {
		LOGGER.info("Call create UserRole");
		try {
			sessionFactory.getCurrentSession().persist(userRole);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create UserRole");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public UserRole readUserRole(int userRoleID) {
		LOGGER.info("Call read UserRole");
		try {
			UserRole userRole = sessionFactory.getCurrentSession().get(UserRole.class, userRoleID);
			return userRole;
		}
		catch(Exception e) {
			LOGGER.error("Can't read UserRole");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateUserRole(UserRole userRole) {
		LOGGER.info("Call update UserRole");
		try {
			sessionFactory.getCurrentSession().update(userRole);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update UserRole");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteUserRole(int userRoleID) {
		LOGGER.info("Call delete UserRole");
		try {
			@SuppressWarnings("unchecked")
			Query<UserRole> query = sessionFactory.getCurrentSession().createQuery("delete from UserRole where userRoleID=:userRoleID");
			query.setParameter("userRoleID", userRoleID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete UserRole");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<UserRole> readAllUserRoles() {
		LOGGER.info("Call read all UserRoles");
		try {
			return sessionFactory.getCurrentSession().createQuery("from UserRole").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all UserRoles");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<UserRole> readUserRoleByProperty(String name, Object value) {
		LOGGER.info("Call read UserRole by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<UserRole> criteriaQuery = builder.createQuery(UserRole.class);
			Root<UserRole> root = criteriaQuery.from(UserRole.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<UserRole> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read UserRole by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
