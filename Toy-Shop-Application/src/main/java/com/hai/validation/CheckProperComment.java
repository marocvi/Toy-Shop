package com.hai.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckProperComment implements ConstraintValidator<Comment,String> {
	
	
	@Override
	public void initialize(Comment constraintAnnotation) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		//Check if comment is proper comment
		return true;
	}


}
