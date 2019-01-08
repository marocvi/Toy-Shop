package com.hai.idao;

import java.util.List;

import com.hai.model.UserRole;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IUserRoleDAO {
	
	public boolean createUserRole(UserRole userRole);
	public UserRole readUserRole(int userRoleID);
	public boolean updateUserRole(UserRole userRole);
	public boolean deleteUserRole(int userRoleID);
	public List<UserRole> readAllUserRoles();
	public List<UserRole> readUserRoleByProperty(String name, Object value);
	
}
