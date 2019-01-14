package com.hai.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy=CheckFiledMatchValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface FieldMatch {

	String message() default "Fileds values doesn't match";
	String field();
	String fieldMatch();
	Class<?>[] groups() default {};
	 
    Class<? extends Payload>[] payload() default {};
	
	
}
