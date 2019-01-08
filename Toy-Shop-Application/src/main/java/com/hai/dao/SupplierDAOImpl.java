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

import com.hai.idao.ISupplierDAO;
import com.hai.model.Supplier;

@Repository("SupplierDAO")
public class SupplierDAOImpl implements ISupplierDAO{
	private Logger LOGGER = Logger.getLogger(SupplierDAOImpl.class);
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean createSupplier(Supplier supplier) {
		LOGGER.info("Call create Supplier");
		try {
			sessionFactory.getCurrentSession().persist(supplier);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't create Supplier");
			return false;
			
		}
	}

	@Override
	@Transactional(readOnly=true)
	public Supplier readSupplier(int supplierID) {
		LOGGER.info("Call read Supplier");
		try {
			Supplier supplier = sessionFactory.getCurrentSession().get(Supplier.class, supplierID);
			return supplier;
		}
		catch(Exception e) {
			LOGGER.error("Can't read Supplier");
			return null;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean updateSupplier(Supplier supplier) {
		LOGGER.info("Call update Supplier");
		try {
			sessionFactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e) {
			LOGGER.error("Can't update Supplier");
			return false;
		}
	}

	@Override
	@Transactional( rollbackFor= {Exception.class})
	public boolean deleteSupplier(int supplierID) {
		LOGGER.info("Call delete Supplier");
		try {
			@SuppressWarnings("unchecked")
			Query<Supplier> query = sessionFactory.getCurrentSession().createQuery("delete from Supplier where supplierID=:supplierID");
			query.setParameter("supplierID", supplierID);
			query.executeUpdate();
			return true;
		}
		catch (Exception e) {
			LOGGER.error("Can't delete Supplier");
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(readOnly=true)
	public List<Supplier> readAllSuppliers() {
		LOGGER.info("Call read all Suppliers");
		try {
			return sessionFactory.getCurrentSession().createQuery("from Supplier").getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read all Suppliers");
			return null;
		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<Supplier> readSupplierByProperty(String name, Object value) {
		LOGGER.info("Call read Supplier by property");
		try {
			
			Session currentSession = sessionFactory.getCurrentSession();
			CriteriaBuilder builder =  currentSession.getCriteriaBuilder();
			CriteriaQuery<Supplier> criteriaQuery = builder.createQuery(Supplier.class);
			Root<Supplier> root = criteriaQuery.from(Supplier.class);
			ParameterExpression<Object> param = builder.parameter(Object.class);
			criteriaQuery.select(root).where(builder.equal(root.get(name), param));
			
			Query<Supplier> query = currentSession.createQuery(criteriaQuery);
			query.setParameter(param, value);
			return query.getResultList();
		}
		catch(Exception e) {
			LOGGER.error("Can't read Supplier by property");
			LOGGER.error(e.getMessage());
			return null;
		}
	}

		
	
}
