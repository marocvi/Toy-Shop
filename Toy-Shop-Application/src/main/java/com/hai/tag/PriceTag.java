package com.hai.tag;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.apache.log4j.Logger;

import com.hai.model.ProductPrice;

public class PriceTag extends SimpleTagSupport {

	private Set<ProductPrice> productPrices;
	private short promotionRate;
	
	Logger LOGGER = Logger.getLogger(PriceTag.class);
	
	@Override
	public void doTag() throws JspException, IOException {
	
		Double unitPrice = 0.0;
		for (ProductPrice price : productPrices) {
			if (new Date().after(price.getStartDate()) && new Date().before(price.getEndDate())) {
				unitPrice = price.getUnitPrice();
			}
		}
		//Change price depending on promottion rate if exist
		if(promotionRate!=0) {
			unitPrice=unitPrice-unitPrice*promotionRate/100;
		}	
		getJspContext().getOut().write(""+new DecimalFormat("0.##").format(unitPrice)+" ");
	}

	public Set<ProductPrice> getProductPrices(){
		return productPrices;
	}

	public void setProductPrices(Set<ProductPrice> productPrices) {
		this.productPrices = productPrices;
	}

	public short getPromotionRate() {
		return promotionRate;
	}

	public void setPromotionRate(short promotionRate) {
		this.promotionRate = promotionRate;
	}
	

	
}
