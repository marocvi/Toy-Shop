package com.hai.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hai.command.UserSignupCommand;
import com.hai.iservice.IUserService;
import com.hai.util.SendingEmailUtil;

@Controller
public class AccountController {

	@Autowired
	private IUserService userService;
	@Autowired
	private SendingEmailUtil emailUtil;

	@PostMapping(value = "/signup")
	public String singup(@Valid UserSignupCommand userSignupCommand, BindingResult result, Model model) {

		if (result.hasErrors()) {
			// Check if there is any error from information user put in
			if (result.getGlobalError() != null) {
				// Check if there is global error, binding it to view
				result.addError(
						new FieldError("userCommand", "retypePassword", result.getGlobalError().getDefaultMessage()));
			}
			model.addAttribute("signupError", "signupError");
			return "home";
		}
		// Save user to DB
		userService.createUser(userSignupCommand);

		// send email
		emailUtil.sendEmailVerifyAccount(userSignupCommand.getEmail());

		return "redirect:home";
	}

	@GetMapping(value = "/verifyAccount")
	public String verifyAccount(@RequestParam("verifyToken") String token, RedirectAttributes model) {
		// Active user
		String error = userService.activateUser(token);
		if (error != null) {
			model.addFlashAttribute("verifyError", error);
		} else {
			model.addFlashAttribute("verifySucess", "You sucessfully verify your ID. You can Login Now");
		}
		return "redirect:home";
	}
	

	@GetMapping(value = "/login")
	public String login(Model model,
			@RequestParam(value="require",required=false) String require,
			@RequestParam(value="error",required=false) String error,
			@RequestParam(value="logout",required=false) String logout	) {
		if(require!=null) {
			model.addAttribute("loginRequire","Please login first");
		}
		else if(error!= null) {
			model.addAttribute("loginError","Your username and password are not correct");
		}
		else if(logout!=null) {
			model.addAttribute("logoutSucess","You've logout sucessfully");
		}
		return "home";
	}
	

}
