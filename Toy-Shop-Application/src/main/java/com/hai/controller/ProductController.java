package com.hai.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hai.ajax.object.CheckLocation;
import com.hai.ajax.object.LocationAvailability;
import com.hai.command.FilterCommand;
import com.hai.command.ReviewCommand;
import com.hai.command.UserSignupCommand;
import com.hai.exception.ProductNotFoundException;
import com.hai.iservice.ICategoryService;
import com.hai.iservice.IDeliveryLocationService;
import com.hai.iservice.IProductColorService;
import com.hai.iservice.IProductImageService;
import com.hai.iservice.IProductService;
import com.hai.iservice.IProductSizeService;
import com.hai.iservice.IReviewService;
import com.hai.model.DeliveryLocation;
import com.hai.model.Product;
import com.hai.model.Review;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;
	@Autowired
	private ICategoryService categoryService;
	@Autowired
	private IProductSizeService productSizeService;
	@Autowired
	private IProductColorService productColorService;
	@Autowired
	private IProductImageService productImageService;
	@Autowired
	private IReviewService reviewService;
	@Autowired
	private IDeliveryLocationService deliveryLocationService;
	
	Logger LOGGER = Logger.getLogger(ProductController.class);
	

	@ModelAttribute
	public void addAttributeModel(Model model) {
		// Send filter object to view
		if (!model.containsAttribute("filterCommand"))
			model.addAttribute("filterCommand", new FilterCommand());
		// Send list of category to view
		model.addAttribute("listOfCategories", categoryService.getAllCategory());
		model.addAttribute("reviewCommand",new ReviewCommand());
	}

	// Using this function when user click to shopping or delete filter
	@RequestMapping(value = { "/product" }, method = RequestMethod.GET)
	public String productByDefault(Model model, @ModelAttribute(value = "filterCommand") FilterCommand filterCommand,
			@RequestParam(value = "page") Integer selectedPage) {
		LOGGER.info("Call  view products reqeust handler");

		List<Product> products = productService.getProductsByFilter(filterCommand);

		// Paginition
		Integer numberOfPages = 0;
		if (products.size() % 9 != 0) {
			numberOfPages = products.size() / 12 + 1;
		} else
			numberOfPages = products.size() / 12;

		// Handling Exception
		if (selectedPage > numberOfPages) {
			throw new ProductNotFoundException();
		}

		// limit result
		int startPosition = selectedPage * 9 - 9;
		int endPosition = startPosition + 9;
		if (endPosition < products.size())
			products = products.subList(startPosition, endPosition);
		else
			products = products.subList(startPosition, products.size());

		// Add result to model
		model.addAttribute("numberOfPages", numberOfPages);
		model.addAttribute("products", products);
		return "product";
	}

	// When applying filter to searchinh for products.
	@RequestMapping(value = { "/product" }, method = RequestMethod.POST)
	public String productByFilter(RedirectAttributes model,
			@ModelAttribute(value = "filterCommand") FilterCommand filterCommand,
			@RequestParam(value = "page") Integer selectedPage) {
		LOGGER.info("Call view products by filter request handler");

		model.addFlashAttribute("filterCommand", filterCommand);
		model.addAttribute("page", selectedPage);

		// Redirect to product page to show products and act request like get method
		return "redirect:product?page={page}";
	}

	/*
	 * View product detail
	 */
	@RequestMapping(value = { "/product/{product_id}" }, method = {RequestMethod.GET,RequestMethod.POST})
	public String showDetailProduct(@PathVariable("product_id") int productId, Model model) {
		LOGGER.info("Call view particular product request handler");

		// Get product detail (price, size, types,description, reviews,information)
		Product product = productService.getPrductById(productId);
		product.setProductSizes(productSizeService.findSizesByProduct(product));
		product.setProductImages(productImageService.findImagesByProduct(product));
		product.setProductColors(productColorService.findColorsByProduct(product));

		// Add to model to show information of a single product to user
		model.addAttribute("product", product);

		return "single";
	}

	/*
	 * Add a new review to the product
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/product/review/{product_id}")
	public String handleReviewProduct(@PathVariable("product_id") int productId, @Valid ReviewCommand reviewCommand,
			BindingResult result, Model model) {
		LOGGER.info("Call review product request handler");
		Product product = productService.getPrductById(productId);;
		// Validation review
		if (result.hasErrors()) {

			// Get product detail (price, size, types,description, reviews,information)
			product.setProductSizes(productSizeService.findSizesByProduct(product));
			product.setProductImages(productImageService.findImagesByProduct(product));
			product.setProductColors(productColorService.findColorsByProduct(product));

			// Add to model to show information of a single product to user
			model.addAttribute("product", product);
			
		
			return "single";
		}
		// Save review to the product
		reviewCommand.setProduct(product);
		Review review = reviewService.getReview(reviewCommand);
		product.getReviews().add(review);
		//Update product to make sure cached review to the cache region
		productService.updateProduct(product);
		return "redirect:/product/" + productId;
	}
	
	/*
	 * Ajax handler for check dilivery location
	 *
	 */
	
	@RequestMapping(value="/api/checkLocation")
	public @ResponseBody LocationAvailability checkLocation(@RequestBody CheckLocation checkLocation) {
		LOGGER.info("Call ajx request handler for checking location");
		boolean result=false;
		//Get location from user then compre to available location from db 
		List<DeliveryLocation> listOfDeliveryLocation = deliveryLocationService.getAllDeliveryLocations();
		for (DeliveryLocation deliveryLocation : listOfDeliveryLocation) {
			if(checkLocation.getDeliveryLocation().equalsIgnoreCase(deliveryLocation.getAvailableLocation())) result=true;
		}
		LocationAvailability locationAvailability = new LocationAvailability();
		locationAvailability.setAvailable(result);
		return locationAvailability;
	}
	
	
	
	

	/*
	 * Exception handler User may click the page doesnt exist or want to view
	 * product doesn't exist
	 * 
	 */
	@ExceptionHandler(ProductNotFoundException.class)
	public String handleProductNotFoundException(ProductNotFoundException ex, Model model) {
		model.addAttribute("erroMsg", ex.getErrorMsg());
		model.addAttribute("erroCode", ex.getErrorCode());
		model.addAttribute("userSignupCommand", new UserSignupCommand());
		return "error_404";
	}

}
