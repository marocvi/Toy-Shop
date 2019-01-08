package com.hai.idao;

import java.util.List;

import com.hai.model.Users;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IUserDAO {
	
	public boolean createUsers(Users user);
	public Users readUsers(int userID);
	public boolean updateUsers(Users user);
	public boolean deleteUsers(int userID);
	public List<Users> readAllUserss();
	public List<Users> readUsersByProperty(String name, Object value);
	
}
