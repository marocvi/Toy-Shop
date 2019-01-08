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

import com.hai.idao.IRoleDAO;
import com.hai.model.Role;

@Repository("RoleDAO")
public class RoleDAOImpl implements IRoleDAO{
	private Logger LOGGER = Logger.getLogger(RoleDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createRole(Role role) {
		LOGGER.info("Call create Role");
		try {
			sessionFactory.getCurrentSession().persist(role);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Role");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Role readRole(int roleID) {
		LOGGER.info("Call read Role");
		try {
			Role role = sessionFactory.getCurrentSession().get(Role.class, roleID);
			return role;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Role");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateRole(Role role) {
		LOGGER.info("Call update Role");
		try {
			sessionFactory.getCurrentSession().update(role);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Role");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteRole(int roleID) {
		LOGGER.info("Call delete Role");
		try {
			@SuppressWarnings("unchecked")
			Query<Role> query = sessionFactory.getCurrentSession().createQuery("delete from Role where roleID=:roleID");
			query.setParameter("roleID", roleID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Role");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Role> readAllRoles() {
		LOGGER.info("Call read all Roles");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Role").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Roles");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Role> readRoleByProperty(String name, Object value) {
		LOGGER.info("Call read Role by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Role> criteriaQuery = builder.createQuery(Role.class);
			Root<Role> root = criteriaQuery.from(Role.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Role> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Role by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
