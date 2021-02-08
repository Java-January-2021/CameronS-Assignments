package com.cameronsmith.productsandcategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showProducts(Model viewModel) {
		List<Product> allProducts = mService.getAllProduct();
		viewModel.addAttribute("products", allProducts);
		return "showAllProducts.jsp";
	}
	@GetMapping("/categories/show")
	public String showCategories(Model viewModel) {
		List<Category> allCategories = mService.getAllCategory();
		viewModel.addAttribute("categories", allCategories);
		return "showAllCategories.jsp";
	}
	@GetMapping("/category/{id}")
	public String categoryInfo(@PathVariable("id")Long id, Model viewModel) {
		Category thisCategory = mService.getCategoryById(id);
		List<Product> thisCategoriesProducts = thisCategory.getProducts();
		List<Product> allProducts = mService.getAllProduct();
		viewModel.addAttribute("products", thisCategoriesProducts);
		viewModel.addAttribute("allProducts", allProducts);
		viewModel.addAttribute("category", thisCategory);
		return "categoryInfo.jsp";
	}
	@PostMapping("/category/{id}")
	public String addProductToCategory(@RequestParam("product")Long productId,@PathVariable("id")Long id) {
		Product productToAdd = this.mService.getProductById(productId);
		Category thisCategory = this.mService.getCategoryById(id);
		this.mService.addProductToCategory(productToAdd, thisCategory);
		return "redirect:/category/{id}";
	}
	@GetMapping("/product/{id}")
	public String productInfo(@PathVariable("id")Long id, Model viewModel) {
		Product thisProduct = mService.getProductById(id);
		List<Category> thisProductsCategories = thisProduct.getCategories();
		List<Category> allCategory = mService.getAllCategory();
		viewModel.addAttribute("allCategory", allCategory);
		viewModel.addAttribute("categories", thisProductsCategories);
		viewModel.addAttribute("product", thisProduct);
		return "productInfo.jsp";
	}
	@PostMapping("/product/{id}")
	public String addCategoryToProduct(@RequestParam("category")Long categoryId, @PathVariable("id")Long id) {
		Category categoryToAdd= this.mService.getCategoryById(categoryId);
		Product thisProduct = this.mService.getProductById(id);
		this.mService.addCategoryToProduct(categoryToAdd, thisProduct);
		return "redirect:/product/{id}";
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
	@GetMapping("/product/{id}/delete")
	public String deleteProduct(@PathVariable("id")Long id) {
		this.mService.deleteProductById(id);
		return "redirect:/products/show";
	}
	@GetMapping("/category/{id}/delete")
	public String deleteCategory(@PathVariable("id")Long id) {
		this.mService.deleteCategoryById(id);
		return "redirect:/categories/show";
	}
	@GetMapping("/{pId}/{cId}/removecategory")
	public String removeProductFromCategory(@PathVariable("pId")Long productId,@PathVariable("cId")Long categoryId) {
		Product productToRemove = this.mService.getProductById(productId);
		Category thisCategory = this.mService.getCategoryById(categoryId);
		this.mService.removeProductFromCategory(productToRemove, thisCategory);
		return "redirect:/product/"+productId;
	}
	@GetMapping("/{cId}/{pId}/removeproduct")
	public String removeCategoryFromProduct(@PathVariable("cId")Long categoryId, @PathVariable("pId")Long productId) {
		Category categoryToRemove= this.mService.getCategoryById(categoryId);
		Product thisProduct = this.mService.getProductById(productId);
		this.mService.removeCategoryFromProduct(categoryToRemove, thisProduct);
		return "redirect:/category/"+categoryId;
	}
}
