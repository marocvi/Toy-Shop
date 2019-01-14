package com.hai.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.exception.InvalidTokenException;
import com.hai.exception.NotExistTokenException;
import com.hai.exception.UserNotFound;
import com.hai.idao.IUserDAO;
import com.hai.idao.IVerifyAccountTokenDAO;
import com.hai.iservice.IVerifyAccountTokenService;
import com.hai.model.Users;
import com.hai.model.VerifyAccountToken;

@Service
public class VerifyAccountTokenServiceImpl implements IVerifyAccountTokenService {

	@Autowired
	IUserDAO userDAO;
	@Autowired
	IVerifyAccountTokenDAO verifyAccountTokenDAO;
	@Autowired
	SessionFactory sessionFactory;
	
	private Logger LOGGER = Logger.getLogger(VerifyAccountTokenServiceImpl.class);
	

	@Override
	public boolean saveVerifyToken(String token, String email) {
		LOGGER.info("Call save verify token");
		// Get user from email
		Users user = null;
		List<Users> users = userDAO.readUsersByProperty("email", email);
		if (users != null && users.size() > 0) {
			user = users.get(0);
		}
		
		//Check if user is exist
		if (user != null) {
			
			//Check with this user has token already, If yes invalidate all of them 
			List<VerifyAccountToken> listOfTokens = verifyAccountTokenDAO.readVerifyAccountTokenByProperty("user", user);
			for (VerifyAccountToken verifyAccountToken : listOfTokens) {
				verifyAccountToken.setEndDate(verifyAccountToken.getCreateDate());
				verifyAccountTokenDAO.updateVerifyAccountToken(verifyAccountToken);
			}
			
			
			//Create new token
			VerifyAccountToken accountToken = new VerifyAccountToken();
			accountToken.setUser(user);
			accountToken.setToken(token);
			accountToken.setCreateDate(new Date());
			//Set up end day 24h after create Date
			Date createDate = new Date();
			Long time = createDate.getTime();
			time=time+(24*60*60*1000);
			Date endDate = new Date(time);
			accountToken.setEndDate(endDate);
			return verifyAccountTokenDAO.createVerifyAccountToken(accountToken);
		}
		else {
			throw new UserNotFound();
		}

	}
	@Override
	@Transactional
	public VerifyAccountToken getVerifyAccountTokenByToken(String token) {
		LOGGER.info("Call get User by using Token ");
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from VerifyAccountToken where token=:token";
			@SuppressWarnings("unchecked")
			Query<VerifyAccountToken> query = session.createQuery(hql);
			query.setParameter("token", token);
			VerifyAccountToken verifyAccountToken = query.getSingleResult();

			// Checking If Token is exist or valid
			if (verifyAccountToken == null) {
				throw new NotExistTokenException();
			}
			if (verifyAccountToken.getEndDate().before(new Date())) {
				throw new InvalidTokenException();
			}
			else {
				return verifyAccountToken;
			}

		} catch (Exception e) {
			LOGGER.error("Can't get User from DB buy using token");
			throw e;
		}
	}

}
