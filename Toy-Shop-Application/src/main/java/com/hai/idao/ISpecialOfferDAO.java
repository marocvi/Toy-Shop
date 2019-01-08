package com.hai.idao;

import java.util.List;

import com.hai.model.SpecialOffer;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface ISpecialOfferDAO {
	
	public boolean createSpecialOffer(SpecialOffer specialOffer);
	public SpecialOffer readSpecialOffer(int specialOfferID);
	public boolean updateSpecialOffer(SpecialOffer specialOffer);
	public boolean deleteSpecialOffer(int specialOfferID);
	public List<SpecialOffer> readAllSpecialOffers();
	public List<SpecialOffer> readSpecialOfferByProperty(String name, Object value);
	
}
