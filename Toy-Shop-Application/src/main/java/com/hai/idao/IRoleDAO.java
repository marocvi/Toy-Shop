package com.hai.idao;

import java.util.List;

import com.hai.model.Role;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IRoleDAO {
	
	public boolean createRole(Role role);
	public Role readRole(int roleID);
	public boolean updateRole(Role role);
	public boolean deleteRole(int roleID);
	public List<Role> readAllRoles();
	public List<Role> readRoleByProperty(String name, Object value);
	
}
