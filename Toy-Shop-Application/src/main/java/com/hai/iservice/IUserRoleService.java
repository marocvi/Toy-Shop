package com.hai.iservice;

import java.util.List;

import com.hai.model.Role.Roles;
import com.hai.model.UserRole;
import com.hai.model.Users;
/**
 * This interface include function help application interace with database and act as helper with other function.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IUserRoleService {
	/**
	 * Find List Of User Roles by using user
	 * @param user
	 * @return
	 */
	public List<UserRole> findUserRoleByUser(Users user);
	
	public void saveUserRole(Users user,Roles role);
	
	
}
