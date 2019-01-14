package com.hai.iservice;

import com.hai.model.VerifyAccountToken;

/** 
 * This interface include useful methods for controller or other to interact with database and more.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IVerifyAccountTokenService {

	
	 /**
	  * Save AccountToken to Database base from input.
	  * @param token To get token property of AccountToken
	  * @param email To get User
	  */
	public boolean saveVerifyToken(String token,String email);
	/**
	 * Using token to get Verify AccountToken
	 * @param token
	 * @return
	 */
	public VerifyAccountToken getVerifyAccountTokenByToken(String token);
	
}
