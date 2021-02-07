package com.cameronsmith.productsandcategories.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.cameronsmith.productsandcategories.models.Category;
import com.cameronsmith.productsandcategories.models.Product;
import com.cameronsmith.productsandcategories.services.MasterService;

@Controller
public class MasterController {
	@Autowired
	private MasterService mService;
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	@GetMapping("/products/show")
	public String showProducts() {
		return "showAllProducts.jsp";
	}
	@GetMapping("/categories/show")
	public String showCategories() {
		return "showAllCategories.jsp";
	}
	@GetMapping("/products/new")
	public String newProducts(@ModelAttribute("product")Product product) {
		return "newProduct.jsp";
	}
	@PostMapping("/products/new")
	public String addProduct(@Valid @ModelAttribute("product")Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "newProduct.jsp";
		}
		this.mService.createProduct(product);
		return "redirect:/products/new";
	}
	@GetMapping("/categories/new")
	public String newCategories(@ModelAttribute("category")Category category) {
		return "newCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String addCategory(@Valid @ModelAttribute("category")Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "newCategory.jsp";
		}
		this.mService.createCategory(category);
		return "redirect:/categories/new";
	}
}
