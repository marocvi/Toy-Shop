package com.hai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	
	@RequestMapping(value="checkout")
	public String checkout() {
		
		
		return "checkout";
	}

}
