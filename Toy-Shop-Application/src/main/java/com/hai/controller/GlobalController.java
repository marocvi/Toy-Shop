package com.hai.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hai.command.UserLoginCommand;
import com.hai.command.UserSignupCommand;

@ControllerAdvice
public class GlobalController {
	
	@ModelAttribute
	public void addUserSignupCommand(Model model) {
		//add UserCommand to all requests of application to invoke signup and signin
		model.addAttribute("userSignupCommand", new UserSignupCommand());
	}
	
	@ModelAttribute
	public void addUserLoginCommand(Model model) {
		model.addAttribute("userLoginCommand", new UserLoginCommand());
	}
	
}
