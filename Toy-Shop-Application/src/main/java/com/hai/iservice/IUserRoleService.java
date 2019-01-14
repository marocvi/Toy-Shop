package com.hai.iservice;

import java.util.List;

import com.hai.model.UserRole;
import com.hai.model.Users;

public interface IUserRoleService {

	public List<UserRole> findUserRoleByUser(Users user);
}
