package com.hai.command;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.hai.validation.CheckExistEmail;
import com.hai.validation.FieldMatch;

@FieldMatch(field="password",fieldMatch="retypePassword")
public class UserSignupCommand {
	

	@NotEmpty(message= "{firstName.notEmpty}")
	private String firstName;
	@NotEmpty(message= "{lastName.notEmpty}")
	private String lastName;
	@NotEmpty(message = "{address.notEmpty}")
	private String address;
	@Email(message="{email.email}")
	@NotEmpty(message="{email.notEmpty}")
	@CheckExistEmail(message = "{email.checkExistEmail}")
	private String email;
	@Size(message ="{password.size}")
	@NotEmpty
	private String password;
	@NotEmpty
	private String retypePassword;
	
	//Getter and setter
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRetypePassword() {
		return retypePassword;
	}
	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}
	

	
	
	
}
