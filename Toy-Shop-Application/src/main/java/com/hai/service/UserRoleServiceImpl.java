package com.hai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.IUserRoleDAO;
import com.hai.iservice.IUserRoleService;
import com.hai.model.UserRole;
import com.hai.model.Users;

@Service
public class UserRoleServiceImpl implements IUserRoleService{
	
	@Autowired
	IUserRoleDAO userRoleDAO ;

	@Override
	public List<UserRole> findUserRoleByUser(Users user) {
		return userRoleDAO.readUserRoleByProperty("user", user);
	}

}
