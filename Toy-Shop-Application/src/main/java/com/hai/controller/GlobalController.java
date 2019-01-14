package com.hai.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.hai.command.UserCommand;

@ControllerAdvice
public class GlobalController {
	
	@ModelAttribute
	public void addUserCommand(Model model) {
		//add UserCommand to all requests of application to invoke signup and signin
		model.addAttribute("userCommand", new UserCommand());
	}
	
}
