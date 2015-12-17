package com.myretail.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myretail.domain.Product;
import com.myretail.services.ProductService;

@Controller
public class LookupController {

	@Autowired
	private ProductService productService;
	private static boolean populated = false;

	@RequestMapping("/index")
	public ModelAndView home() {

		if (!populated) {

			productService.add(new Product("010001", "Milk", "Land O Lakes",
					"Full Cream Milk, 1 Gallon", 100));
			productService.add(new Product("020001", "Soda",
					"Coca Cola Company", "Regular, 2 Liter Bottle", 0));
			productService.add(new Product("030001", "Juice", "Land O Lakes",
					"Orange Juice, 1 Gallon ", 100));
			productService.add(new Product("040001", "Coffee", "Folgers",
					"Dark Roast Arabica, 64oz ", 100));
			productService.add(new Product("050001", "Butter", "Crystal",
					"Salted Butter 1 Lbs, 4 Stricks", 100));

			populated = true;
		}

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("index");
		List<Product> products = productService.findAllProducts();
		mv.addObject("products", products);
		return mv;
	}

	@RequestMapping(value = "/findAllProductsInStock", method = RequestMethod.GET)
	public ModelAndView findAllAvailable() {

		ModelAndView mv = new ModelAndView("index");
		List<Product> products = productService.findAllProductsInStock();
		mv.addObject("products", products);
		return mv;
	}

	@RequestMapping(value = "/findAllProductsOutOfStock", method = RequestMethod.GET)
	public ModelAndView findAllProductsOutOfStock() {

		ModelAndView mv = new ModelAndView("index");
		List<Product> products = productService.findAllProductsOutOfStock();
		mv.addObject("products", products);
		return mv;
	}

	@RequestMapping(value = "/searchproduct", method = RequestMethod.POST)
	public ModelAndView addBook(@RequestParam("productId") String productId) {
		ModelAndView mv = new ModelAndView("index");
		List<Product> products = productService.searchProductById(productId);
		mv.addObject("products", products);
		return mv;
	}
}
