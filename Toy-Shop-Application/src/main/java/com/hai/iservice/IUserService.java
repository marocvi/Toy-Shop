package com.hai.iservice;

import com.hai.command.UserSignupCommand;
import com.hai.model.Users;

/**
 * This interface include useful methods for controller to interact with database and more.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IUserService {
	
	/**
	 * Create new User using userCommand Infromation 
	 * @param userCommand
	 */
	public void createUser(UserSignupCommand userCommand);
	/**
	 * Checking whether with particular email exist
	 * @param email
	 * @return
	 */
	public boolean checkExistEmail(String email);
	
	
	/**
	 * This function using token to activate user from registratiion
	 * @param token
	 * @return
	 */
	public String activateUser(String token);
	
	/**
	 * This function using token to get Users
	 * @param token
	 * @return
	 */
	public Users getUserByToken(String token);
	
	
	
	
}
