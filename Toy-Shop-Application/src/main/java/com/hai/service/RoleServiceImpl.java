package com.hai.service;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.IRoleDAO;
import com.hai.iservice.IRoleService;
import com.hai.model.Role;

@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	IRoleDAO roleDAO;
	
	@Autowired
	SessionFactory sessionFactory ;
	
	Logger LOGGER = Logger.getLogger(RoleServiceImpl.class);

	@Override
	@Transactional
	public Role getRole(String roleName) {
		LOGGER.info("Call get Role ");
		try {
			@SuppressWarnings("unchecked")
			Query<Role> query = sessionFactory.getCurrentSession().createQuery("from Role where roleName=:roleName");
			query.setParameter("roleName", roleName);
			
			return query.getSingleResult();
		}
		catch(Exception e ) {
			LOGGER.error("Can't get Role");
			e.printStackTrace();
			return null;
		}
	}
	
	
}
