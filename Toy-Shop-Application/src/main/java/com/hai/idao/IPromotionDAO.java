package com.hai.idao;

import java.util.List;

import com.hai.model.Promotion;

/**
 * This interface including crud methods for interacting with database.
 * @author Mai_Van_Hai
 * @version 1.0
 * @since 2018-10-20
 */
public interface IPromotionDAO {
	
	public boolean createPromotion(Promotion promotion);
	public Promotion readPromotion(int promotionID);
	public boolean updatePromotion(Promotion promotion);
	public boolean deletePromotion(int promotionID);
	public List<Promotion> readAllPromotions();
	public List<Promotion> readPromotionByProperty(String name, Object value);
	
}
