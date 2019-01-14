package com.hai.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public  class CheckFiledMatchValidator implements ConstraintValidator<FieldMatch, Object> {
	String field;
	String fieldMatch;
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		this.field = constraintAnnotation.field();
		this.fieldMatch = constraintAnnotation.fieldMatch();
		
	}
	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		Object fieldValue = new BeanWrapperImpl(value).getPropertyValue(field);
		Object fielddMatchValue = new BeanWrapperImpl(value).getPropertyValue(fieldMatch);
		if(fieldValue.equals(fielddMatchValue))
			return true;
		return false;
	}

}
