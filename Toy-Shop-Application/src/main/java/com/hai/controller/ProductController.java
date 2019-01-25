package com.hai.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hai.command.FilterCommand;
import com.hai.iservice.ICategoryService;
import com.hai.iservice.IProductService;
import com.hai.model.Product;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	
	

	@ModelAttribute
	public void addAttributeModel(Model model) {
		//Send filter object to view
		model.addAttribute("filterCommand", new FilterCommand());
		//Send list of category to view
		model.addAttribute("listOfCategories", categoryService.getAllCategory());
	}
	//Using this function when user click to shopping or delete filter
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String productByDefault(Model model,@ModelAttribute(value = "filterCommand") FilterCommand filterCommand) {
		List<Product> products = new ArrayList<>();
		products = productService.getProductsByFilter(filterCommand, 0, 9);
		model.addAttribute("products", products);
		System.out.println(filterCommand);
		return "product";
	}
	
	//When applying filter to searchinh for products.
	@RequestMapping(value = { "/product" }, method = RequestMethod.POST)
	public String productByFilter(Model model, @ModelAttribute(value = "filterCommand") FilterCommand filterCommand) {

		List<Product> products = new ArrayList<>();
		products = productService.getProductsByFilter(filterCommand, 0, 9);
		System.out.println(filterCommand);
		model.addAttribute("products", products);
		return "product";
	}


}
