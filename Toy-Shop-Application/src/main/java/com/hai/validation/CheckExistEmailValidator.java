package com.hai.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.hai.iservice.IUserService;

public class CheckExistEmailValidator implements ConstraintValidator<CheckExistEmail, String> {

	@Autowired
	private IUserService userService;
	
	
	@Override
	public void initialize(CheckExistEmail constraintAnnotation) {
		//Do nothing
	}

	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		if (userService.checkExistEmail(email))
			return false;
		return true;
	}

}
