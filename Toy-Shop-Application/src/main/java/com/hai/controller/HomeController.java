package com.hai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {


	@RequestMapping(value = {"/","home"}, method=RequestMethod.GET)
	public String getHome(Model model) {
		return "home";
	}
	@RequestMapping(value="about")
	public String getAbout() {
		return "about";
	}
	@RequestMapping(value="service")
	public String getService() {
		return "service";
	}
	@RequestMapping(value="contact")
	public String getContact() {
		return "contact";
	}
}
