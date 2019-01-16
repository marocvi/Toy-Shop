package com.hai.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hai.idao.IUserRoleDAO;
import com.hai.iservice.IRoleService;
import com.hai.iservice.IUserRoleService;
import com.hai.model.Role;
import com.hai.model.Role.Roles;
import com.hai.model.UserRole;
import com.hai.model.Users;

@Service
public class UserRoleServiceImpl implements IUserRoleService{
	
	@Autowired
	IUserRoleDAO userRoleDAO ;
	
	@Autowired
	IRoleService roleService;

	@Override
	public List<UserRole> findUserRoleByUser(Users user) {
		return userRoleDAO.readUserRoleByProperty("user", user);
	}

	@Override
	public void saveUserRole(Users user, Roles roleName) {
		
		Role role = roleService.getRole(roleName.toString());
		//Create User Role
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setStartDate(new Date());
		userRole.setUser(user);
		//Save UserRole to DB
		userRoleDAO.createUserRole(userRole);
	}

}
