package com.hai.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.hai.command.UserSignupCommand;
import com.hai.exception.InvalidTokenException;
import com.hai.exception.NotExistTokenException;
import com.hai.idao.IUserDAO;
import com.hai.iservice.IUserRoleService;
import com.hai.iservice.IUserService;
import com.hai.iservice.IVerifyAccountTokenService;
import com.hai.model.MyUserDetails;
import com.hai.model.Role.Roles;
import com.hai.model.Users;
import com.hai.model.Users.LoginStatus;

@Service
public class UserServiceImpl implements IUserService,UserDetailsService {
	private final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private IUserDAO userDAO;
	@Autowired
	private IVerifyAccountTokenService verifyAccountTokenService;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	SessionFactory sessionFactory;
	
	@Autowired
	IUserRoleService userRoleService;

	@Override
	public void createUser(UserSignupCommand userCommand) {
		LOGGER.info("Call create User");
		Users user = new Users();
		user.setFirstName(userCommand.getFirstName());
		user.setLastName(userCommand.getLastName());
		user.setAddress(userCommand.getAddress());
		user.setEmail(userCommand.getEmail());
		// Encode password for security purpose
		user.setPasswords(encoder.encode(userCommand.getPassword()));
		user.setCreateDate(new Date());
		user.setLoginStatus(LoginStatus.PENDING.toString());
		userDAO.createUsers(user);
	}

	@Override
	@Transactional
	public boolean checkExistEmail(String email) {
		LOGGER.info("Call check exist email");
		// Checking Email
		Session session = sessionFactory.getCurrentSession();
		try {
			String hql = "from Users where email=:email";
			@SuppressWarnings("unchecked")
			Query<Users> query = session.createQuery(hql);
			query.setParameter("email", email);
			List<Users> listOfUsers = query.getResultList();
			if (listOfUsers.size() >= 1) {
				return true;
			} else
				return false;
		} catch (Exception e) {
			LOGGER.warn("Can't check email.There are some errors.Please check.");
			return true;
		}

	}

	@Override
	public String activateUser(String token) {
		LOGGER.info("Call activate User");
		String error = null;
		try {
			Users user = getUserByToken(token);
			if (user.getLoginStatus().equals("ACTIVE")) {
				//Check wehter user active yet
				error = "User already active";
			} else {
				//Active User
				user.setLoginStatus(LoginStatus.ACTIVE.toString());
				user.setCreateDate(new Date());
				//Create role for user;
				userRoleService.saveUserRole(user,Roles.USER);
				userDAO.updateUsers(user);
			}
		} catch (InvalidTokenException exInvalid) {
			LOGGER.error("Can't activate User beacause there no User is loaded by using given token");
			error = exInvalid.getMessage();
		} catch (NotExistTokenException exNotExistToken) {
			LOGGER.error("Can't activate User beacause there no User is loaded by using given token");
			error = exNotExistToken.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.error("Can't activate User");
			error = "Internal Error!";
		}
		return error;
	}

	@Override
	public Users getUserByToken(String token) {
		return verifyAccountTokenService.getVerifyAccountTokenByToken(token).getUser();
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		//Get User from DB from email or usernam user enter.
		Users user = userDAO.readByEmail(email);
		MyUserDetails userDetails =null;
		if(user != null) {
			//If user not null initilize User Detail
			//First Set Role for user
			user.setRoles(userRoleService.findUserRoleByUser(user));
			//Second Initilize UserDetails
			userDetails  = new MyUserDetails(user);
		}
		return userDetails;
	}

	@Override
	public Users getUserByEmail(String email) {
	
		return userDAO.readByEmail(email);
	}


}
