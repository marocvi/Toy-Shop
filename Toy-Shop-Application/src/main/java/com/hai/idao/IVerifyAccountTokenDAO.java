package com.hai.idao;

import java.util.List;

import com.hai.model.VerifyAccountToken;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IVerifyAccountTokenDAO {
	
	public boolean createVerifyAccountToken(VerifyAccountToken verifyAccountToken);
	public VerifyAccountToken readVerifyAccountToken(int verifyAccountTokenID);
	public boolean updateVerifyAccountToken(VerifyAccountToken verifyAccountToken);
	public boolean deleteVerifyAccountToken(int verifyAccountTokenID);
	public List<VerifyAccountToken> readAllVerifyAccountTokens();
	public List<VerifyAccountToken> readVerifyAccountTokenByProperty(String name, Object value);
	
}
