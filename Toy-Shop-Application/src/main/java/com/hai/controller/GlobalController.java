package com.hai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hai.command.UserLoginCommand;
import com.hai.command.UserSignupCommand;
import com.hai.config.security.IAuthenticationFacade;
import com.hai.iservice.IUserService;

@ControllerAdvice
public class GlobalController {

	@Autowired
	IAuthenticationFacade authenticationFacade;
	@Autowired
	IUserService userService;

	@ModelAttribute
	public void addUserSignupCommand(Model model) {
		// add UserCommand to all requests of application to invoke signup and signin
		model.addAttribute("userSignupCommand", new UserSignupCommand());
	}

	@ModelAttribute
	public void addUserLoginCommand(Model model) {
		model.addAttribute("userLoginCommand", new UserLoginCommand());
	}

	@ModelAttribute
	public void addUserAuthenticated(Model model) {
		if (!authenticationFacade.getAuthentication().getName().isEmpty())
			model.addAttribute("user", userService.getUserByEmail(authenticationFacade.getAuthentication().getName()));
	}

}
