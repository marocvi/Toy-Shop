package com.hai.tag;

import java.util.Date;
import java.util.Set;

import com.hai.model.Promotion;

public class DiscountTag {

	public static int getPromotionRate(Set<Promotion> promotions) {

		if (promotions.size()>0) {
			for (Promotion promotion : promotions) {
				//Check wether promotionRate is valid
				if(promotion.getCreateDate().before(new Date())&&promotion.getEndDate().after(new Date())) {
					return promotion.getRate();
				}
			}
			return 0;
		}
		else {
			return 0;
		}

	}

}
